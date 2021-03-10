package org.geektimes.projects.user.service.impl;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.repository.UserRepository;
import org.geektimes.projects.user.service.UserService;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserServiceImpl implements UserService {

    /**
     *  去掉旧的手动创建方式，改成注入的方式
     */
    //private UserRepository userRepository = new DatabaseUserRepository();

    @Resource(name = "bean/EntityManager")
    private EntityManager entityManager;

    @Override
    public boolean register(User user) {
        boolean ret = true;
        try{
            // before process
            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(user);

            // after process
            transaction.commit();

        }catch (Exception e){
            ret = false;
        }
        return ret;
    }

    @Override
    public boolean deregister(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User queryUserById(Long id) {
        return null;
    }

    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        return null;
    }
}
