package cn.eli.dao.impl;

import cn.eli.dao.UserDao;
import cn.eli.entity.EliUserEntity;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Repository("userDao") //进行注入
public class UserrDaoImpl implements UserDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public void add(EliUserEntity user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public boolean login(EliUserEntity user) {
        Iterator<EliUserEntity> it;
        String hsql = "FROM EliUserEntity as u where u.name=? and u.password=?";
        System.out.println(hsql);
        Query query = sessionFactory.getCurrentSession().createQuery(hsql);
        query.setString(0, user.getName());
        query.setString(1, user.getPassword());
        System.out.println(user.getName());
        it = query.iterate();
        if (it.hasNext()) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }

    @Override
    public List getUser() {
        return sessionFactory.getCurrentSession().createQuery("FROM User").list();
    }

    @Override
    public EliUserEntity getUser(int id) {
        return (EliUserEntity)sessionFactory.getCurrentSession().get(EliUserEntity.class, id);
    }

    @Override
    public void update(EliUserEntity user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession().delete(
                sessionFactory.getCurrentSession().get(EliUserEntity.class, id)
        );
    }
}
