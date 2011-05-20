package com.codequality.assembly.dao.impl;

import com.codequality.assembly.BaseTransactionalTest;
import com.codequality.assembly.dao.BuildDao;
import com.codequality.assembly.dao.CategoryDao;
import com.codequality.assembly.domain.Build;
import com.codequality.assembly.domain.Category;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class BuildDaoImplIntegrationTest extends BaseTransactionalTest {

    @Autowired(required = true)
    private BuildDao buildDao;
    @Autowired(required = true)
    private CategoryDao categoryDao;

    @Test
    public void testListByCategoryName() throws Exception {
        Category level1 = new Category("level1", "Level 1");
        categoryDao.insert(level1);

        Category level2_1 = new Category("level2_1", "Level 2");
        level1.addSubCategory(level2_1);
        categoryDao.insert(level2_1);

        Category level2_2 = new Category("level2_2", "Level 2");
        level1.addSubCategory(level2_2);
        categoryDao.insert(level2_2);

        Build build1 = new Build("test build 1", "test build 1 summary", level2_1);
        buildDao.insert(build1);

        Build build2 = new Build("test build 2", "test build 2 summary", level2_1);
        buildDao.insert(build2);

        Build build3 = new Build("test build 3", "test build 3 summary", level2_2);
        buildDao.insert(build3);

        List<Build> level1Builds = buildDao.listByCategoryName("level2_1");

        assertThat(level1Builds.size(), equalTo(2));
    }

}
