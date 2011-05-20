package com.codequality.assembly.dao.impl;

import com.codequality.assembly.dao.CategoryDao;
import com.codequality.assembly.domain.Category;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

    @Override
    @SuppressWarnings({"unchecked"})
    public List<Category> listSubCategoriesByCategoryName(String name){
        Query query = createQuery("from Category where parent.name = :name");
        query.setString("name", name);
        return query.list();
    }

    @Override
    public Category getByCategoryName(String name) {
        Query query = createQuery("from Category c where c.name = :name");
        query.setString("name", name);
        return (Category) query.uniqueResult();
    }

}
