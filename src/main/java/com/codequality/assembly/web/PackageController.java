package com.codequality.assembly.web;

import com.codequality.assembly.dao.CategoryDao;
import com.codequality.assembly.domain.Build;
import com.codequality.assembly.domain.Category;
import com.codequality.assembly.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.*;

@Controller
@RequestMapping("package")
public class PackageController {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ShopService shopService;

    @RequestMapping("/index")
    public ModelAndView index(){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("level2Categories", Collections.EMPTY_LIST);
        return new ModelAndView("package/index", modelMap);
    }

    @RequestMapping("/{level1}/{level2}")
    public ModelAndView level1(@PathVariable String level1, @PathVariable String level2){
        checkNotNull(level1);

        Map<String, Object> modelMap = new HashMap<String, Object>();
        Category level1Category = categoryDao.getByCategoryName(level1);
        List<Category> level2Categories = categoryDao.listSubCategoriesByCategoryName(level1);
        modelMap.put("level1Category", level1Category);
        modelMap.put("level2Categories", level2Categories);
        String categoryName;
        if ("index".equals(level2)) {
            categoryName = level1Category.getName();
        }
        else {
            categoryName = level1Category.getName();
            Category level2Category = categoryDao.getByCategoryName(level2);
            modelMap.put("level2Category", level2Category);
        }
        List<Build> builds = shopService.listAllSubcategoriesBuilds(categoryName);
        modelMap.put("builds", builds);
        return new ModelAndView("package/index", modelMap);
    }

}
