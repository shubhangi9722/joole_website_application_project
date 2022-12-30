package com.itlizesession.Service.Implements;

import com.itlizesession.Entity.User;
import com.itlizesession.Repository.UserRepository;
import com.itlizesession.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplements implements UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByuserName(username).orElse(null);
    }

    @Override
    public List<User> listAll() {
        return repository.findAll();
    }

    @Override
    public User updateUser(User user, int userId) {
        User existingUser = repository.findById(userId).orElse(null);

        // asserting as these operations will take place only when its not null
        assert existingUser != null;
        existingUser.setUserName(user.getUserName());
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());
        existingUser.setEmail(user.getEmail());
        return repository.save(existingUser);
    }

    @Override
    public void deleteUserById(int userId) {
//        repository.findById(userId)
//                .orElseThrow(() -> new UserNotFoundException(userId));
        repository.deleteById(userId);
    }

    @Override
    public Optional<User> findUserById(int id) {
        return Optional.empty();
    }

}
