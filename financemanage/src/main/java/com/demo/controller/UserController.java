package com.demo.controller;

import com.demo.base.BaseController;
import com.demo.base.ResponseDataMessage;
import com.demo.dao.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/addUser")
    public ResponseDataMessage addUser(@RequestBody User user) {
        userService.addUser(user);
        return this.success();
    }
}
