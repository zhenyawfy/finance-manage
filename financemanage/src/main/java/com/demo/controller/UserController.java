package com.demo.controller;

import com.demo.base.BaseController;
import com.demo.base.ResponseDataMessage;
import com.demo.dao.User;
import com.demo.dao.UserAssets;
import com.demo.service.UserAssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends BaseController {
    @Autowired
    private UserAssetsService assetsService;

    @PostMapping(value = "/queryAssets")
    public ResponseDataMessage queryAssets(@RequestBody UserAssets assets) {
        return this.success(assetsService.queryByUserId(assets.getUserId()));
    }

    @PostMapping(value = "/addAssets")
    public ResponseDataMessage addAssets(@RequestBody UserAssets assets) {
        UserAssets userAssets = assetsService.queryByUserId(assets.getUserId());
        if (userAssets.getCreateTime() != null) {
            return this.error("409", "已存在不允许修改！");
        } else {
            assetsService.saveAssets(assets);
        }
        return this.success();
    }
}
