package com.lxt.demo.service.impl;

import com.lxt.demo.dao.TestDao;
import com.lxt.demo.dao.UserDao;
import com.lxt.demo.entity.User;
import com.lxt.demo.service.TestService;
import com.lxt.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false)
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;


    @Override
    public void refresh(User user){
        testDao.refresh(user);
    }
}
