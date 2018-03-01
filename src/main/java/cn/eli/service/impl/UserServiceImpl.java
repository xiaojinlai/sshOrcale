package cn.eli.service.impl;

import cn.eli.dao.UserDao;
import cn.eli.entity.EliUserEntity;
import cn.eli.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public boolean addUser(EliUserEntity user) {
        this.userDao.add(user);
        return true;
    }

    @Override
    public boolean login(EliUserEntity user) {
        return this.userDao.login(user);
    }

    @Override
    public List getAllUser() {
        return this.userDao.getUser();
    }

    @Override
    public EliUserEntity getUserById(int id) {
        return this.userDao.getUser(id);
    }

    @Override
    public boolean updateUser(EliUserEntity user) {
        this.userDao.update(user);
        return true;
    }

    @Override
    public boolean deleteUser(int id) {
        this.userDao.delete(id);
        return true;
    }
}
