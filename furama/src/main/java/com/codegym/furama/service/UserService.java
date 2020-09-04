package com.codegym.furama.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    UserDetails loadUserByUserName(String userName);
}
