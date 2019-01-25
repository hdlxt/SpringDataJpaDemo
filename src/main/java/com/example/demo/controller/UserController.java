package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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

    Logger logger = LoggerFactory.getLogger(UserController.class);
    /**
     * 返回结果
     */
    private final static String REPONSE_SUCCESS = "SUCCESS!";
    private final static String REPONSE_ERR = "ERROR!";
    @Autowired
    private UserDao userDao;

    /**
     *
     * 查询所有
     * @return
     */
    @RequestMapping("/list")
    public List<User> list(){
        return userDao.findAll();
    }

    /**
     * 插入
     * @param name
     * @param number
     * @return
     */
    @RequestMapping("/persisNew/{name}/{number}")
    public String persisNew(@PathVariable("name")String name
        ,@PathVariable("number")String number){
        userDao.persist(new User().setName(name).setNumber(number));
        return REPONSE_SUCCESS;
    }
    /**
     * 持久化删除态的对象
     *@param id
     * @return
     */
    @RequestMapping("/persistRemove/{id}")
    public String persistRemove(@PathVariable("id")Long id){
        try {
            User user = userDao.findById(id);
            userDao.persistRemove(user);
        }catch (Exception e){
            logger.error("持久化一个删除态的对象!",e);
            return REPONSE_ERR;
        }
        return REPONSE_SUCCESS;
    }
    /**
     * 持久化游离态的对象
     *@param id
     * @return
     */
    @RequestMapping("/persisDetached/{id}")
    public String persisDetached(@PathVariable("id")Long id){
        try {
            User user = userDao.findById(id);
            userDao.clear();
            userDao.persist(user);
        }catch (Exception e){
            logger.error("持久化一个游离态的对象!",e);
            return REPONSE_ERR;
        }
        return REPONSE_SUCCESS;
    }
    /**
     * 持久化删除态的对象
     *@param id
     * @return
     */
    @RequestMapping("/mergeRemove/{id}")
    public String mergeRemove(@PathVariable("id")Long id){
        try {
            User user = userDao.findById(id);
            userDao.mergeRemove(user);
        }catch (Exception e){
            logger.error("合并(merge)一个删除态的对象!",e);
            return REPONSE_ERR;
        }
        return REPONSE_SUCCESS;
    }
    /**
     * 持久化游离态的对象
     *@param id
     * @return
     */
    @RequestMapping("/mergeDetached/{id}")
    public String mergeDetached(@PathVariable("id")Long id){
        try {
            User user = userDao.findById(id);
            userDao.mergeDetached(user);
        }catch (Exception e){
            logger.error("合并(merge)一个游离态的对象!",e);
            return REPONSE_ERR;
        }
        return REPONSE_SUCCESS;
    }

    /**
     * 刷新new出来的对象
     *@param id
     * @return
     */
    @RequestMapping("/refreshNew")
    public String refreshNew(){
        try {
            User user = new User().setName("lxt").setNumber("007");
            userDao.refresh(user);
        }catch (Exception e){
            logger.error("刷新(refresh)一个new的对象!",e);
            return REPONSE_ERR;
        }
        return REPONSE_SUCCESS;
    }
    /**
     * 刷新删除态对象
     *@param id
     * @return
     */
    @RequestMapping("/refreshRemove/{id}")
    public String refreshRemove(@PathVariable("id")Long id){
        try {
            User user = userDao.findById(id);
            userDao.refreshRemove(user);
        }catch (Exception e){
            logger.error("刷新(refresh)一个删除态的对象!",e);
            return REPONSE_ERR;
        }
        return REPONSE_SUCCESS;
    }
    /**
     * 刷新游离态对象
     *@param id
     * @return
     */
    @RequestMapping("/refreshDetached/{id}")
    public String refreshDetached(@PathVariable("id")Long id){
        try {
            User user = userDao.findById(id);
            userDao.refreshDetached(user);
        }catch (Exception e){
            logger.error("刷新(refresh)一个游离态的对象!",e);
            return REPONSE_ERR;
        }
        return REPONSE_SUCCESS;
    }
    /**
     * 刷新托管态对象
     *@param id
     * @return
     */
    @RequestMapping("/refreshManaged/{id}")
    public String refreshManaged(@PathVariable("id")Long id){
        try {
            User user = userDao.findById(id);
            userDao.refreshManaged(user);
        }catch (Exception e){
            logger.error("刷新(refresh)一个托管态的对象!",e);
            return REPONSE_ERR;
        }
        return REPONSE_SUCCESS;
    }


    /**
     * 删除new出来的对象
     *@param id
     * @return
     */
    @RequestMapping("/removeNew/{id}")
    public String removeNew(@PathVariable("id")Long id){
        try {
            User user = new User().setId(id).setName("lxt").setNumber("007");
            userDao.remove(user);
        }catch (Exception e){
            logger.error("删除(remove)一个new的对象!",e);
            return REPONSE_ERR;
        }
        return REPONSE_SUCCESS;
    }
    /**
     * 删除 删除态对象
     *@param id
     * @return
     */
    @RequestMapping("/removeRemove/{id}")
    public String removeRemove(@PathVariable("id")Long id){
        try {
            User user = userDao.findById(id);
            userDao.removeRemove(user);
        }catch (Exception e){
            logger.error("删除(remove)一个删除态的对象!",e);
            return REPONSE_ERR;
        }
        return REPONSE_SUCCESS;
    }
    /**
     * 删除游离态对象
     *@param id
     * @return
     */
    @RequestMapping("/removeDetached/{id}")
    public String removeDetached(@PathVariable("id")Long id){
        try {
            User user = userDao.findById(id);
            userDao.removeDetached(user);
        }catch (Exception e){
            logger.error("删除(remove)一个游离态的对象!",e);
            return REPONSE_ERR;
        }
        return REPONSE_SUCCESS;
    }


}
