package com.codegym.furama.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class webSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService userDetailsService;
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder managerBuilder) throws Exception{
        managerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    @Override
    public void configure(HttpSecurity http)throws Exception{
        http
                .authorizeRequests()
                //Cau hinh cho duong dan khong co xac thuc
                .antMatchers("/","/login","/register").permitAll()
                //cau hinh cho duong dan Role la Member or Addmin
                .antMatchers("/review","/booking").hasAnyRole("MEMBER","ADMIN")
                //Cau hinh cho duong dan Role la Admin
                .antMatchers("/admin").hasRole("ADMIN")
                .and()
                // formLogin
                .formLogin()
                // duowng dan tra ve formLogin
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                //neu login thannh cong
                .defaultSuccessUrl("/")
                // neu login that bai
                .failureUrl("/login?error")
                //neu login thanh cong nhung lai vao trang khong dung Role
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403");

    }

}
