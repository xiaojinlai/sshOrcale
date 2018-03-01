package cn.eli.service;

import cn.eli.entity.EliUserEntity;

import java.util.List;

public interface UserService {

    boolean addUser(EliUserEntity user);

    boolean login(EliUserEntity user);

    List getAllUser();

    EliUserEntity getUserById(int id);

    boolean updateUser(EliUserEntity user);

    boolean deleteUser(int id);
}
