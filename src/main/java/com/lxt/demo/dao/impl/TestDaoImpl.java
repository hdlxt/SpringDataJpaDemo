package com.lxt.demo.dao.impl;

import com.lxt.demo.dao.TestDao;
import com.lxt.demo.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TestDaoImpl implements TestDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void refresh(User user){
        entityManager.refresh(user);
    }
}
