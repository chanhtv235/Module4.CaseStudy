package com.codegym.furama.service.impl;

import com.codegym.furama.Entity.Role;
import com.codegym.furama.Entity.User;
import com.codegym.furama.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository repository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       User user =repository.findByEmail(s);
        if (user==null){
            throw new UsernameNotFoundException(" not found user");
        }
        Set<GrantedAuthority> grantedAuthorities=new HashSet<>();
        Set<Role> roles= user.getRoles();
        for (Role role:roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),user.getPassword(),grantedAuthorities);


    }
}
