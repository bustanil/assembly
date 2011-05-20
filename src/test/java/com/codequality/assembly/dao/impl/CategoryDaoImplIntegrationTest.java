package com.codequality.assembly.dao.impl;

import com.codequality.assembly.BaseTransactionalTest;
import com.codequality.assembly.dao.CategoryDao;
import com.codequality.assembly.domain.Category;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class CategoryDaoImplIntegrationTest extends BaseTransactionalTest {

    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void testListSubCategoriesByCategoryName() throws Exception {
        Category root = new Category("root category", null);
        categoryDao.insert(root);

        Category level1 = new Category("level 1 category", null);
        root.addSubCategory(level1);
        categoryDao.insert(level1);
        categoryDao.update(root);

        Category level2 = new Category("level 2 category", null);
        level1.addSubCategory(level2);
        categoryDao.insert(level2);
        categoryDao.update(level1);

        List<Category> level1Categories = categoryDao.listSubCategoriesByCategoryName("root category");
        assertThat(level1Categories.size(), equalTo(1));
        assertThat(level1Categories.get(0).getName(), equalTo("level 1 category"));

        List<Category> level2Categories = categoryDao.listSubCategoriesByCategoryName("level 1 category");
        assertThat(level2Categories.size(), equalTo(1));

    }

    @Test
    public void testGetByCategoryName() throws Exception {
        Category category1 = new Category("category 1", null);
        categoryDao.insert(category1);

        Category category2 = new Category("category 2", null);
        categoryDao.insert(category2);
        Category result = categoryDao.getByCategoryName("category 1");
        assertThat(result, notNullValue());
        assertThat(result.getName(), equalTo("category 1"));
        assertThat(categoryDao.getByCategoryName("category 3"), nullValue());
    }
}
