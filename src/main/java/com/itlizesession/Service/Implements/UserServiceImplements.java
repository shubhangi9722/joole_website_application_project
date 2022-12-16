
package com.itlizesession.Service.Implements;



import com.itlizesession.Entity.User;
import com.itlizesession.Repository.UserRepository;
import com.itlizesession.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplements implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User saveUser(User user) {
        Optional<User> savedUser = repository.findByEmail(user.getEmail());
        if(savedUser.isPresent()){
            System.out.println("Employee already exist with given email:" + user.getEmail());
        }
        return repository.save(user);
    }

    @Override
    public List<User> listAll() {
        return repository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).orElse(null);

        // asserting as these operations will take place only when its not null
        assert existingUser != null;
        existingUser.setUserName(user.getUserName());
        existingUser.setPassword(user.getPassword());
        existingUser.setUser_type(user.getUser_type());
        existingUser.setEmail(user.getEmail());
        return repository.save(existingUser);
    }

    @Override
    public void deleteUserById(int userId) {
//        repository.findById(userId)
//                .orElseThrow(() -> new UserNotFoundException(userId));
        repository.deleteById(userId);
    }
}
