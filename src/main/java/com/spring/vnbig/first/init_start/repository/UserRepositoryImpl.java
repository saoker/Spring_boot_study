package com.spring.vnbig.first.init_start.repository;

import com.spring.vnbig.first.init_start.domain.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepositoryImpl implements UserRepository {
    public static AtomicLong atomicId;
    public ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<Long, User>();


    public UserRepositoryImpl(){
        User user = new User();
        user.setId((long) 30);
        user.setName("dudu");
        this.addUser(user);
    }

    @Override
    public User getUserbyId(Long id) {
        User usertemp = userMap.get(id);
        if (usertemp == null) {
            return null;
        }
        return usertemp;
    }

    @Override
    public void deleteUser(Long id) {
        userMap.remove(id);
    }

    @Override
    public User addUser(User user) {
        Long id = user.getId();
        if (id == null) {
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
