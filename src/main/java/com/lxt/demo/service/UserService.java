package com.lxt.demo.service;

import com.lxt.demo.entity.User;

public interface UserService {


    void save(User user);

    User get(Long id);

    User handler(User user);
}
