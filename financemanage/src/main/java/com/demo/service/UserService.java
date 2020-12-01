package com.demo.service;

import com.demo.dao.User;
import com.demo.mapper.UserMapper;
import com.demo.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public long addUser(User user) {
        Date currDate = new Date();
        user.setCreateTime(currDate);
        user.setUpdateTime(currDate);
        user.setId(IdUtils.getId());
        return userMapper.addUser(user);
    }
}
