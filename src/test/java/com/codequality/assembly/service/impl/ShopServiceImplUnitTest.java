package com.codequality.assembly.service.impl;

import com.codequality.assembly.dao.CategoryDao;
import com.codequality.assembly.domain.Build;
import com.codequality.assembly.domain.Category;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class ShopServiceImplUnitTest {

    private ShopServiceImpl shopService;

    @Mock
    private CategoryDao categoryDao;

    @Before
    public void setUp() throws Exception {
        shopService = new ShopServiceImpl();
        initMocks(this);
        shopService.setCategoryDao(categoryDao);
    }

    @Test
    public void testListAllSubcategoriesBuilds() throws Exception {
         Category level1 = new Category("level1", "Level 1");

        Category level2_1 = new Category("level2_1", "Level 2");
        level1.addSubCategory(level2_1);

        Category level2_2 = new Category("level2_2", "Level 2");
        level1.addSubCategory(level2_2);

        new Build("test build 1", "test build 1 summary", level2_1);
        new Build("test build 2", "test build 2 summary", level2_1);
        new Build("test build 3", "test build 3 summary", level2_2);

        when(categoryDao.getByCategoryName("level1")).thenReturn(level1);

        List<Build> builds = shopService.listAllSubcategoriesBuilds("level1");
        assertThat(builds.size(), equalTo(3));

        verify(categoryDao).getByCategoryName(eq("level1"));
    }

}
