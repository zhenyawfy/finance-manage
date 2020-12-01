package com.demo.mapper;

import com.demo.dao.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    long addUser(User user);
}
