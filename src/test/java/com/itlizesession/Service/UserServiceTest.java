package com.itlizesession.Service;

import com.itlizesession.Entity.Role;
import com.itlizesession.Entity.User;
import com.itlizesession.Repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository repo;

    @Test
    void saveUser() {
        User user = new User();
        user.setUserName("defgwerg");
        user.setEmail("defgwerg@gmail.com");
        user.setPassword("dfhskdg");
        user.setRole(Role.ADMIN);
        User savedUser = userService.saveUser(user);
        Assertions.assertEquals("defgwerg",savedUser.getUserName());
    }

    @Test
    void listAll() {
        Iterable<User> users = userService.listAll();
        assertThat(users).hasSizeGreaterThan(0);

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void updateUser() {
        User user = repo.getById(8);
        user.setRole(Role.ADMIN);
        repo.save(user);
        Assertions.assertEquals("Consumer",user.getRole());
    }

    @Test
    void deleteUserById() {
        Optional<User> user;
        user = repo.findByuserName("gfh");
        userService.deleteUserById(user.orElseThrow().getId());
    }
}