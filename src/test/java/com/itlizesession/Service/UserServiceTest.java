package com.itlizesession.Service;

import com.itlizesession.Entity.Role;
import com.itlizesession.Entity.User;
import com.itlizesession.Repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository repo;

    @Test
    void createUser() {
        User user = new User();
        user.setUserName("kiki Chen");
        user.setEmail("kiki@gmail.com");
        user.setPassword("kiki123");
        user.setRole(Role.USER);
        userService.saveUser(user);

        User savedUser = repo.findById(user.getId()).orElse(null);
        Assertions.assertEquals(user, savedUser);
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
    void updateRole() {
        User user = repo.findById(40).orElse(null);
        user.setRole(Role.ADMIN);
        userService.updateUser(user,40);
        Assertions.assertEquals("ADMIN",user.getRole());
    }

    @Test
    void testSetRole() {
        User user = repo.findById(2).orElse(null);
        System.out.println(user);
        user.setRole(Role.ADMIN);
        userService.saveUser(user);
    }

    @Test
    void deleteUserById() {
        Optional<User> user;
        user = repo.findByuserName("Qingrong");
        userService.deleteUserById(user.orElseThrow().getId());
    }
}