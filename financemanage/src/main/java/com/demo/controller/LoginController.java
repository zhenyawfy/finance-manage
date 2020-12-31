package com.demo.controller;

import com.demo.base.BaseController;
import com.demo.base.ResponseDataMessage;
import com.demo.base.Token;
import com.demo.dao.User;
import com.demo.service.UserService;
import com.demo.utils.EncryptUtil;
import com.demo.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController extends BaseController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/userLogin")
    public ResponseDataMessage userLogin(@RequestBody User user) {
        User u = userService.findByLoginName(user.getLoginName());
        if (u == null) {
            return this.error("201", "用户不存在！");
        }
        if (SecurityUtils.verifyPassword(user.getPwd(), u.getPwd())) {
            Token token = EncryptUtil.createToken(String.valueOf(u.getId()), u.getLoginName());
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("user", u);
            map.put("token", token);
            return this.success(map);
        }
        return this.error("202", "用户名或密码错误！");
    }
}
