package com.spring.vnbig.first.init_start.repository;

import com.spring.vnbig.first.init_start.domain.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;


/*
@Repository
public class UserRepositoryImpl implements UserRepository {
    public static AtomicLong atomicId = new AtomicLong();
    public ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<Long, User>();


    public UserRepositoryImpl() {
//        User user = new User();
//        user.setId(30);
//        user.setName("dudu");
//        user.setEmail("@qq.com");
//        this.addUser(user);
    }

    @Override
    public <S extends User> Iterable<S> save(Iterable<S> entities) {
        return null;
    }

    @Override
    public User findOne(Long id) {
        return userMap.get(id);
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public void delete(Long id) {
        userMap.remove(id);
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void delete(Iterable<? extends User> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public User save(User user) {
        Long id = user.getId();
        if (id <= 0) {
            id = atomicId.incrementAndGet();
            user.setId(id);
        }
        userMap.put(id, user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<User>(userMap.values());
    }

    @Override
    public Iterable<User> findAll(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}*/
