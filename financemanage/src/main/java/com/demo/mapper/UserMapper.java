package com.demo.mapper;

import com.demo.dao.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    long addUser(User user);

    User findByLoginName(@Param("loginName") String loginName);
}
