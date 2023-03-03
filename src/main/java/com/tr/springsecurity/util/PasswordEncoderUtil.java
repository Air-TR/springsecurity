package com.tr.springsecurity.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author taorun
 * @date 2023/1/30 15:02
 */
public class PasswordEncoderUtil {

    public static void main(String[] args) {
        System.out.println(encode("123456"));
    }

    public static String encode(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

}
