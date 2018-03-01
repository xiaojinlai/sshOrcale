package cn.eli.dao;

import cn.eli.entity.EliUserEntity;

import java.util.List;

public interface UserDao {
    /**
     * 添加并保存用户
     *
     * @param user
     */
    void add(EliUserEntity user);

    /**
     * 进行登录
     */
    boolean login(EliUserEntity user);


    /**
     * 获取用户列表
     */
    List getUser();

    /**
     * 根据用户Id获取用户信息
     *
     * @param id
     * @return
     */
    EliUserEntity getUser(int id);

    /**
     * 更新用户信息
     *
     * @param user
     */
    void update(EliUserEntity user);


    /**
     * 根据用户id删除用户信息
     *
     * @param id
     */
    void delete(int id);
}
