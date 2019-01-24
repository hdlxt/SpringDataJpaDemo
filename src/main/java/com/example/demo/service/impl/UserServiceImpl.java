package com.example.demo.service.impl;

import com.example.demo.controller.UserController;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 刘小通
 * @Copy Right Information: 中科软科技股份有限公司
 * @Project: GTS4
 * @CreateDate: 2019/1/22 21:10
 * @history Sr Date Modified By Why & What is modified
 * 1.2019/1/22 刘小通 & new
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class.getName());

    @Autowired
    private UserDao userDao;


    /**
     * 瞬时 -> 托管
     *
     * @param user
     */
    @Override
    public User testNew2Managed(User user) {
        userDao.persist(user);
        user.setNumber(user.getNumber()+"-managed");
        return user;
    }

    /**
     * 持久化一个游离态的对象
     *
     * @param user
     */
    @Override
    public void testPersistDetached(Long id) {
//        User user = userDao.findById(id);
//        logger.info("user:"+user);
////        userDao.remove(user);
//
//        user.setNumber("1");
        userDao.merge(new User().setId(5L).setName("tes111t"));
//        user.setNumber("2");
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    /**
     * 持久化对象
     *
     * @param user
     */
    @Override
    public void persist(User user) {
        userDao.persist(user);
    }

    /**
     * 删除对象
     *
     * @param user
     */
    @Override
    public void remove(User user) {
        userDao.remove(user);
    }

    /**
     * 合并对象
     *
     * @param user
     */
    @Override
    public void merge(User user) {
        userDao.merge(user);
    }

    /**
     * 刷新对象
     *
     * @param user
     */
    @Override
    public void refresh(User user) {
        userDao.refresh(user);
    }
}
