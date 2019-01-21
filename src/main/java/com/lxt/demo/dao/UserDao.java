package com.lxt.demo.dao;

import com.lxt.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
}
