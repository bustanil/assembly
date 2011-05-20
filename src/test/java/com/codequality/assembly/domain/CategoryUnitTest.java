package com.codequality.assembly.domain;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class CategoryUnitTest {

    @Test(expected = IllegalArgumentException.class)
    public void testAddSubCategory_nullCategory() throws Exception {
        Category c = new Category();
        c.addSubCategory(null);
    }

    @Test
    public void testAddSubCategory() throws Exception {
        Category c = new Category();
        c.addSubCategory(new Category());
        assertThat(c.getSubCategories().size(), equalTo(1));
    }

}
