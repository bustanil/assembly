package com.codequality.assembly.dao;

import com.codequality.assembly.domain.Build;

import java.util.List;

public interface BuildDao extends BaseDao<Build> {

    List<Build> listByCategoryName(String categoryName);

}
