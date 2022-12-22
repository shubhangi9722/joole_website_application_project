package com.itlizesession.Controllers;

import com.itlizesession.Entity.User;
import com.itlizesession.Service.UserService;
import com.itlizesession.Service.MyUserDetailsService;
import com.itlizesession.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager myauthenticaitonManager;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return service.saveUser(user);
    }

//    @PostMapping("/addUsers")
//    public List<User> addUsers(@RequestBody List<User> users) {
//        return service.saveUsers(users);
//    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return service.listAll();
    }

//    @GetMapping("/user/{id}")
//    public User findUserById(int id) {
//        return service.(id);
//    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(int id) {
        service.deleteUserById(id);
    }


    //sign in
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestParam(name="username") String username,
                                                       @RequestParam(name="password") String password)
    //@RequestBody User User)
            throws Exception {

        try {
            myauthenticaitonManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,password)//User.getUsername(), User.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(username);//User.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return  new ResponseEntity<>(jwt, HttpStatus.OK);
    }
}

