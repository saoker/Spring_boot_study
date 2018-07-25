package com.spring.vnbig.first.init_start.repository;

import com.spring.vnbig.first.init_start.domain.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepositoryImpl implements UserRepository {
    public static AtomicLong atomicId = new AtomicLong();
    public ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<Long, User>();


    public UserRepositoryImpl() {
        User user = new User();
        user.setId(30);
        user.setName("dudu");
        user.setEmail("@qq.com");
        this.addUser(user);
    }

    @Override
    public User getUserbyId(Long id) {
        return userMap.get(id);
    }

    @Override
    public void deleteUser(Long id) {
        userMap.remove(id);
    }

    @Override
    public User addUser(User user) {
        Long id = user.getId();
        if (id <= 0) {
            id = atomicId.incrementAndGet();
            user.setId(id);
        }
        userMap.put(id, user);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return new ArrayList<User>(userMap.values());
    }
}
