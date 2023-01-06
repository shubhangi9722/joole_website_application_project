package com.itlizesession.Controllers;

import com.itlizesession.Entity.Role;
import com.itlizesession.Entity.User;
import com.itlizesession.Entity.Project;
import com.itlizesession.Service.UserService;
import com.itlizesession.Service.MyUserDetailsService;
import com.itlizesession.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final AuthenticationManager authenticatonManager;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @GetMapping("/user")
    public ResponseEntity<?> allUsers(){
        List<User> users = userService.listAll();
        if(users == null || users.isEmpty()){
            return new ResponseEntity<>("no users found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> addUser(
            @RequestParam("userName") String username,
            @RequestParam("userPassword") String userPassword,
            @RequestParam("email") String email)
            {

        User newUser = new User();
        newUser.setUserName(username);
        newUser.setPassword(userPassword);
        newUser.setEmail(email);
        newUser.setRole(Role.USER);
        User createdUser = userService.saveUser(newUser);
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }
    //sign in
    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestParam(name="username") String username,
                                                       @RequestParam(name="password") String password)
            throws Exception {

        try {
            authenticatonManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,password)//User.getUsername(), User.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(username);//loadUserByUsername()返回的是授予用户的权限//User.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return  new ResponseEntity<>(jwt, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestParam("id") int userId){
        User user = userService.findUserById(userId).orElse(null);
        if(user==null){
            return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
        }
        userService.deleteUserById(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);

    }

    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestParam("id") int userid, User userDetails){
        User user = userService.findUserById(userid).orElse(null);
        if(user==null){
            return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
        }
        user.setUserName(userDetails.getUserName());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());
        userService.saveUser(user);
        return new ResponseEntity<>("updated user" + user.toString(), HttpStatus.OK);
    }

}