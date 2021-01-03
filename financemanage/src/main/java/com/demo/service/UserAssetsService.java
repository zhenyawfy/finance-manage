package com.demo.service;

import com.demo.dao.User;
import com.demo.dao.UserAssets;
import com.demo.mapper.UserAssetsMapper;
import com.demo.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Date;

@Service
public class UserAssetsService {

    @Autowired
    private UserAssetsMapper assetsMapper;

    public UserAssets queryByUserId(long userId) {
        UserAssets userAssets = assetsMapper.queryByUserId(userId);
        if (userAssets == null) {
            userAssets = new UserAssets("0.00", "0.00", "0.00", "0.00", "0.00");
        }
        return userAssets;
    }

    public void saveAssets(UserAssets assets) {
        assets.setId(IdUtils.getId());
        Date date = new Date();
        assets.setCreateTime(date);
        assets.setUpdateTime(date);
        DecimalFormat df = new DecimalFormat("0.00");
        String goalConservativeAmt = df.format(Double.valueOf(assets.getMonthUseAmt()) * 1200 / 8);
        assets.setGoalConservativeAmt(goalConservativeAmt);
        assetsMapper.saveAssets(assets);
    }
}
