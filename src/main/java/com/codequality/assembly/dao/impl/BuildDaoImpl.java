package com.codequality.assembly.dao.impl;

import com.codequality.assembly.dao.BaseDao;
import com.codequality.assembly.dao.BuildDao;
import com.codequality.assembly.domain.Build;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BuildDaoImpl extends BaseDaoImpl<Build> implements BuildDao {

    @Override
    @SuppressWarnings("unchecked")
    public List<Build> listByCategoryName(String categoryName) {
        Query query = createQuery("select b from Build b where b.category.name = :categoryName");
        query.setString("categoryName", categoryName);
        return query.list();
    }
}
