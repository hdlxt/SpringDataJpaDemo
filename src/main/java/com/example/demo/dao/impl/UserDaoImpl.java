package com.example.demo.dao.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author 刘小通
 * @Copy Right Information: 中科软科技股份有限公司
 * @Project: GTS4
 * @CreateDate: 2019/1/22 23:04
 * @history Sr Date Modified By Why & What is modified
 * 1.2019/1/22 刘小通 & new
 */
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public User findById(Long id) {
        return (User) entityManager.createQuery("from User where id=:id")
                .setParameter("id",id)
                .getSingleResult();
    }

    /**
     * 持久化对象
     *
     * @param user
     */
    @Override
    public void persist(User user) {
        entityManager.persist(user);
    }

    /**
     * 删除对象
     *
     * @param user
     */
    @Override
    public void remove(User user) {
        entityManager.remove(user);
    }

    /**
     * 合并对象
     *
     * @param user
     */
    @Override
    public void merge(User user) {
        entityManager.merge(user);
    }

    /**
     * 刷新对象
     *
     * @param user
     */
    @Override
    public void refresh(User user) {
        entityManager.refresh(user);
    }
}
