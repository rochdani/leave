package com.example.leavemanagement.controller;

import com.example.leavemanagement.model.User;
import com.example.leavemanagement.repository.UserRepository;

import com.example.leavemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;



    @Autowired
    private UserRepository userRepository;


    @PostMapping("/register")
    public User usersaved(@RequestBody User users) throws Exception
    {
        String tempNameId=users.getUsername();
        if(tempNameId !=null && !"".equals(tempNameId)) {
            User userObj=userRepository.findByUsername(tempNameId);
            if(userObj !=null) {
                throw new Exception("user with"+tempNameId+"already exit");
            }
        }
        User userObj=null;
        userObj=userRepository.save(users);
        return userObj;
    }

    @PostMapping("/login")
    public User login(@RequestBody User users) throws Exception {
        String tempName=users.getUsername();
        String temPass=users.getPassword();

        User userObj=null;
        if(tempName!=null && temPass!=null) {
            userObj=userRepository.findByUsernameAndPassword(tempName,temPass);
        }
        if(userObj ==null)
        {
            throw new Exception("bad credetials");
        }

        return userObj;
    }





}
