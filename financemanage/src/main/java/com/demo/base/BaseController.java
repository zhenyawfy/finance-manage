package com.demo.base;

import org.springframework.http.HttpStatus;

public class BaseController {

    public ResponseDataMessage success() {
        return new ResponseDataMessage("200", "success", null);
    }

    public ResponseDataMessage success(Object data) {
        return new ResponseDataMessage("200", "success", data);
    }

    public ResponseDataMessage error(String code, String msg) {
        return new ResponseDataMessage(code, msg);
    }
}
