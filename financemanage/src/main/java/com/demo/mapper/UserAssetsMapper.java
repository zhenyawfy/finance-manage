package com.demo.mapper;

import com.demo.dao.UserAssets;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserAssetsMapper {
    UserAssets queryByUserId(@Param("userId") long userId);
    void saveAssets(UserAssets assets);
}
