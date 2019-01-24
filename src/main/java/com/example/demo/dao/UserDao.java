package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 刘小通
 * @Copy Right Information: 中科软科技股份有限公司
 * @Project: GTS4
 * @CreateDate: 2019/1/22 21:09
 * @history Sr Date Modified By Why & What is modified
 * 1.2019/1/22 刘小通 & new
 */
@Transactional(rollbackFor = Exception.class)
public interface UserDao{
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
