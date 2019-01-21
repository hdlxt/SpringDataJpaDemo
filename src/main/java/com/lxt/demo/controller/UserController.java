package com.lxt.demo.controller;

import com.lxt.demo.dao.UserDao;
import com.lxt.demo.entity.User;
import com.lxt.demo.service.TestService;
import com.lxt.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private  UserDao userDao;
    @Autowired
    private  UserService userService;
    @Autowired
    private TestService testService;
    @RequestMapping("/save/{name}")
    public  User save(@PathVariable("name") String name){
        User user = new User().setName(name);
//        testService.refresh(user);
        return userDao.save(user);
    }

    @RequestMapping("/get1/{id}")
    public  void get1(@PathVariable("id") Long id){
        System.out.println("==================start1=================");
        User user = userDao.getOne(id);
        System.out.println("id:"+user.getId());
        System.out.println("name:"+user.getName());
        System.out.println("==================end1=================");
    }
    @RequestMapping("/get2/{id}")
    public  void get2(@PathVariable("id") Long id){
        System.out.println("==================start2=================");
        User user = userDao.getOne(id);
        System.out.println("user："+user);
        System.out.println("==================end2=================");
    }

    @RequestMapping("/get3/{id}")
    public  void get3(@PathVariable("id") Long id){
        System.out.println("==================start3=================");
        User user = userService.get(id);
        user.setName("test!");
        System.out.println("========>user-1:"+user);
        testService.refresh(user);
        System.out.println("========>user-2:"+user);
        System.out.println("==================end3=================");
    }

    @RequestMapping("/testPersist")
    public  void testPersist(){
    }
    @RequestMapping("/testRemove")
    public  void testRemove(){
    }
    @RequestMapping("/testRefresh")
    public  void testRefresh(){
    }
    @RequestMapping("/testMerge")
    public  void testMerge(){
    }

}
