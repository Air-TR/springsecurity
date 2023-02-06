package com.tr.springsecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author taorun
 * @date 2023/1/30 15:02
 */
public class Test {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123"));
    }

}
