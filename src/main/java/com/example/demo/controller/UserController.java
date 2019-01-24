package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 刘小通
 * @Copy Right Information: 中科软科技股份有限公司
 * @Project: GTS4
 * @CreateDate: 2019/1/22 21:17
 * @history Sr Date Modified By Why & What is modified
 * 1.2019/1/22 刘小通 & new
 */
@RestController
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;
    /**
     * 测试持久化一个游离态的对象
     * @return
     */
    @RequestMapping("/testNew2Managed")
    public String testNew2Managed(){
        User user = new User().setName("lxt").setNumber("001");
        userService.testNew2Managed(user);
        return "success!";
    }
    /**
     * 测试持久化一个游离态的对象
     * @return
     */
    @RequestMapping("/testPersistDetached/{id}")
    public String testPersistDetached(@PathVariable("id")Long id){
        try {
            userService.testPersistDetached(id);
        }catch (Exception e){
            e.printStackTrace();
            return "success!";
        }
        return "fail!";
    }



}
