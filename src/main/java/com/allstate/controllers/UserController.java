package com.allstate.controllers;

import com.allstate.entities.User;
import com.allstate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public User create(@RequestBody Map<String, String> json){
        return this.userService.create(json.get("email"));
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Iterable<User> findAll(){
        return this.userService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findUserById(@PathVariable int id){
        return this.userService.findUserById(id);
    }
}
