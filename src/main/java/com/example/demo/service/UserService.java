package com.example.demo.service;

import com.example.demo.entity.User;

/**
 * @author 刘小通
 * @Copy Right Information: 中科软科技股份有限公司
 * @Project: GTS4
 * @CreateDate: 2019/1/22 21:09
 * @history Sr Date Modified By Why & What is modified
 * 1.2019/1/22 刘小通 & new
 */
public interface UserService {
    /**
     * 瞬时 -> 托管
     * @param user
     */
    User testNew2Managed(User user);
    /**
     * 持久化一个游离态的对象
     *  @param id
     */
    void testPersistDetached(Long id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    User findById(Long id);
    /**
     * 持久化对象
     * @param user
     */
    void persist(User user);

    /**
     * 删除对象
     * @param user
     */
    void remove(User user);
    /**
     * 合并对象
     * @param user
     */
    void merge(User user);
    /**
     * 刷新对象
     * @param user
     */
    void refresh(User user);


}
