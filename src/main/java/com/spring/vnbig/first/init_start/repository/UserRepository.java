package com.spring.vnbig.first.init_start.repository;

import com.spring.vnbig.first.init_start.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


public interface UserRepository extends CrudRepository<User, Long> {
}



/*

public interface UserRepository {

    public User getUserbyId(Long id);

    public void deleteUser(Long id );

    public User addUser(User user);

    public List<User> findAll();
}
*/
