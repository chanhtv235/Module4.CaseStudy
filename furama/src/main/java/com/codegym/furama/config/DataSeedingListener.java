package com.codegym.furama.config;

import com.codegym.furama.Entity.Role;
import com.codegym.furama.Entity.User;
import com.codegym.furama.repository.RoleRepository;
import com.codegym.furama.repository.UserRepository;
import com.codegym.furama.utils.EncrypPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Null;
import java.util.HashSet;
@Component
public class DataSeedingListener implements ApplicationListener {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (roleRepository.findByName("ROLE_ADMIN") == null) {
            roleRepository.save(new Role("ROLE_ADMIN"));
        }

        if (roleRepository.findByName("ROLE_MEMBER") == null) {
            roleRepository.save(new Role("ROLE_MEMBER"));
        }
        // them Addmin
        if(userRepository.findByEmail("admin@gmail.com")==null){
            User admin =new User();
            admin.setEmail("admin@gmail.com");
            admin.setPassword(EncrypPasswordUtils.EncrupPasswordUtils("123456"));
            HashSet<Role> roles=new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_ADMIN"));
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            admin.setRoles(roles);
            userRepository.save(admin);
        }
        // them Member
        if(userRepository.findByEmail("member@gmail.com")==null){
            User user =new User();
            user.setEmail("member@gmail.com");
            user.setPassword(EncrypPasswordUtils.EncrupPasswordUtils("123456"));
            HashSet<Role> roles=new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            user.setRoles(roles);
            userRepository.save(user);
        }
    }



}
