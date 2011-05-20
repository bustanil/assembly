package com.codequality.assembly.service.impl;

import com.codequality.assembly.dao.BuildDao;
import com.codequality.assembly.dao.CategoryDao;
import com.codequality.assembly.domain.Build;
import com.codequality.assembly.domain.Category;
import com.codequality.assembly.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    @Transactional
    public List<Build> listAllSubcategoriesBuilds(String categoryName) {
        List<Build> result = new ArrayList<Build>();
        Category category = categoryDao.getByCategoryName(categoryName);
        for (Category subCategory : category.getSubCategories()) {
            if(!subCategory.getSubCategories().isEmpty()){
                for (Category subSubCategory : subCategory.getSubCategories()) {
                    result.addAll(subSubCategory.getBuilds());
                }
            }
            result.addAll(subCategory.getBuilds());
        }
        return result;
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

}
