package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
     * 查询所有
     * @return
     */
    List<User> findAll();
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
     * 合并删除态的对象
     *
     * @param user
     */
    void mergeRemove(User user);
    /**
     * 持久化删除态的对象
     *
     * @param user
     */
    void persistRemove(User user);
    /**
     * 合并对象
     * @param user
     * @return
     */
    User merge(User user);
    /**
     * 合并游离态的对象
     *
     * @param user
     */
    void mergeDetached(User user);

    /**
     * 刷新对象
     * @param user
     */
    void refresh(User user);
    /**
     * 刷新游离态的对象
     *
     * @param user
     */
    void refreshDetached(User user);
    /**
     * 刷新托管态的对象
     *
     * @param user
     */
    void refreshManaged(User user);
    /**
     * 刷新删除态的对象
     *
     * @param user
     */
    void refreshRemove(User user);
    /**
     * 删除游离态的对象
     *
     * @param user
     */
    void removeDetached(User user);
    /**
     * 删除 删除态的对象
     *
     * @param user
     */
    void removeRemove(User user);
    /**
     * 清除session
     */
    void clear();
    /**
     * 关闭session
     */
    void close();
}
