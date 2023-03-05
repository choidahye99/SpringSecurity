package com.example.ssiach2ex1.config;

import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService(){
        var userDetailsService = new InMemoryUserDetailsManager();

        var user = User.withUsername("John")
                .password("12345")
                .authorities("read")
                .build();

        userDetailsService.createUser(user);


        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        var userDetailsService = new InMemoryUserDetailsManager();

        var user = User.withUsername("John")
                .password("12345")
                .authorities("read")
                .build();

        userDetailsService.createUser(user);

        auth.userDetailsService(userDetailsService)
                .passwordEncoder(
                        NoOpPasswordEncoder.getInstance()
                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests()
                .anyRequest().authenticated(); //모든 요청에 인증을 요구하도록 지정
//                .anyRequest().permitAll(); //인증없이 요청할 수 있다.
    }
}
