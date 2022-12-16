package com.itlizesession.Repository;


import com.itlizesession.Entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repo;

    @Test
    public void testAddNew() {
        User user = new User();
        user.setUserName("gfh");
        user.setEmail("gfh@gmail.com");
        user.setPassword("rgrtjy");
        user.setUser_type("customer");
        User savedUser = repo.save(user);
        Assertions.assertEquals("gfh",user.getUserName());
    }

    @Test
    public void listAll() {
        Iterable<User> users = repo.findAll();

        //Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user : users) {
            System.out.println(user);
        }
    }
}
