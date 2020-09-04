package com.codegym.furama.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrypPasswordUtils {
    public static String EncrupPasswordUtils(String password){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

}
