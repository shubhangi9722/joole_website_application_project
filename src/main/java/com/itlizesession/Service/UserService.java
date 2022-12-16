package com.itlizesession.Service;


import com.itlizesession.Entity.User;

import java.util.List;


public interface UserService {

    // save operation
    User saveUser(User user);

    // read operation
    List<User> listAll();

    // update operation
    User updateUser(User user);

    // delete operation
    void deleteUserById(int userId);

}
