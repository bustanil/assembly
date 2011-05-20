package com.codequality.assembly.service;

import com.codequality.assembly.domain.Build;

import java.util.List;

public interface ShopService {

    List<Build> listAllSubcategoriesBuilds(String categoryName);
}
