package com.itlizesession.Service;


import com.itlizesession.Entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    // save operation
    User saveUser(User user);

    User findByUsername(String username);

    // read operation
    List<User> listAll();

    // update operation
    User updateUser(User user, int userId);

    // delete operation
    void deleteUserById(int userId);

    Optional<User> findUserById(int id);
}
