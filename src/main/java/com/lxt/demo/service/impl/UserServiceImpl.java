package com.lxt.demo.service.impl;

import com.lxt.demo.dao.UserDao;
import com.lxt.demo.entity.User;
import com.lxt.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User get(Long id) {
        return userDao.getOne(id);
    }

    @Override
    public User handler(User user) {
        System.out.println("user:"+user);
        return user;
    }
}
