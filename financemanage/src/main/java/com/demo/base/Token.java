package com.demo.base;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

public class Token implements Serializable, Cloneable {

    String token_type;
    String access_token;
    long expires_in;

    String userId;

    String msg;

    public Token() {
        super();
    }

    public Token(String msg) {
        super();
        this.msg = msg;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public boolean isReturnMsg() {
        return StringUtils.isNotBlank(msg);
    }

    public boolean isSameInfo(Token other) {
        if (this == other) return true;
        if (null == other) return false;
        return toStringWithoutTimes().equals(other.toStringWithoutTimes());
    }

    public String toStringWithoutTimes() {
        return toString();
    }
}
