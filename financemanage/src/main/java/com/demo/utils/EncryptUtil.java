package com.demo.utils;

import com.demo.base.Token;
import com.demo.dao.User;
import io.jsonwebtoken.Claims;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;

/**
 * 名称：MD5加密类
 */
public class EncryptUtil {
    // ACCESS_EXPIRES_IN 对应jwt生成acess_token的有效时间
    private static final long ACCESS_EXPIRES_IN = 24 * 60 * 60 * 1000L;

    /**
     * Used building output as Hex
     */
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 对字符串进行MD5加密
     *
     * @param text 明文
     * @return 密文
     */
    public static String md5(String text) {
        MessageDigest msgDigest = null;

        try {
            msgDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(
                    "System doesn't support MD5 algorithm.");
        }

        msgDigest.update(text.getBytes());
        byte[] bytes = msgDigest.digest();
        String md5Str = new String(encodeHex(bytes));
        return md5Str;
    }

    public static char[] encodeHex(byte[] data) {
        int l = data.length;
        char[] out = new char[l << 1];
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS[0x0F & data[i]];
        }
        return out;
    }

    public static Token authorize(User user, String password, HttpServletRequest request) {
        if (!SecurityUtils.verifyPassword(password, user.getPwd())) {
            return null;
        }
        return createToken(String.valueOf(user.getId()), user.getLoginName());
    }

    public static Token createToken(String uuid, String loginId) {
        String token_uuid1 = UUID.randomUUID().toString().replaceAll("-", "");
        String accessToken = JwtUtil.createJWT(uuid, loginId, token_uuid1, ACCESS_EXPIRES_IN);

        Token token = new Token();
        token.setToken_type("finance");
        token.setExpires_in(ACCESS_EXPIRES_IN);
        token.setAccess_token(accessToken);
        token.setUserId(uuid);
        return token;
    }

    public static boolean validate(String uuid, String access_token) {
        if (uuid == null) {
            return false;
        }
        Claims claims = JwtUtil.parseJWT(access_token);
        if (claims == null) {
            return false;
        }

        if (!uuid.equals(claims.get("uuid"))) {
            return false;
        }

        Date date = new Date();
        if (date.before(claims.getNotBefore()) || date.after(claims.getExpiration())) {
            return false;
        }
        return true;
    }

}
