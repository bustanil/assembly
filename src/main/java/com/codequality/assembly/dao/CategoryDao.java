package com.codequality.assembly.dao;

import com.codequality.assembly.domain.Category;

import java.util.List;

public interface CategoryDao extends BaseDao<Category> {

    List<Category> listSubCategoriesByCategoryName(String name);

    Category getByCategoryName(String level1);
}
