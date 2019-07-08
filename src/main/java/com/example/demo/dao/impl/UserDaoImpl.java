package com.example.demo.dao.impl;

import com.example.demo.controller.UserController;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author 刘小通
 * @CreateDate: 2019/1/22 23:04
 * @history Sr Date Modified By Why & What is modified
 * 1.2019/1/22 刘小通 & new
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDaoImpl implements UserDao {
    Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;


    /**
     * 查询所有
     * @return
     */
    @Override
    public List<User> findAll() {
        return entityManager.createQuery("from User").getResultList();
    }

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
     * 持久化删除态的对象
     *
     * @param user
     */
    @Override
    public void persistRemove(User user) {
        remove(user);
        persist(user);
        user.setName("persist remove success!");
    }

    /**
     * 合并对象
     *
     * @param user
     */
    @Override
    public User merge(User user) {
        return entityManager.merge(user);
    }

    /**
     * 合并删除态的对象
     *
     * @param user
     */
    @Override
    public void mergeRemove(User user) {
        remove(user);
        merge(user);
    }
    /**
     * 合并游离态的对象
     *
     * @param user
     */
    @Override
    public void mergeDetached(User user) {
        clear();
        User newUser = merge(user);
        newUser.setName("newUser merge detached success!");
        user.setName("user merge detached success!");
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
    /**
     * 刷新游离态的对象
     *
     * @param user
     */
    @Override
    public void refreshDetached(User user) {
        clear();
        refresh(user);
    }
    /**
     * 刷新托管态的对象
     *
     * @param user
     */
    @Override
    public void refreshManaged(User user) {
        user.setName("refresh before!");
        refresh(user);
        logger.info("user:"+user);
    }
    /**
     * 刷新删除态的对象
     *
     * @param user
     */
    @Override
    public void refreshRemove(User user) {
       remove(user);
       user.setName("refresh remove before！");
       refresh(user);
        user.setName("refresh remove after！");
    }
    /**
     * 删除游离态的对象
     *
     * @param user
     */
    @Override
    public void removeDetached(User user) {
        clear();
        remove(user);
    }
    /**
     * 删除 删除态的对象
     *
     * @param user
     */
    @Override
    public void removeRemove(User user) {
        remove(user);
        remove(user);
    }
    /**
     * 清除session
     */
    @Override
    public void clear(){
        entityManager.clear();
    }
    /**
     * 关闭session
     */
    @Override
    public void close(){
        entityManager.close();
    }
}
