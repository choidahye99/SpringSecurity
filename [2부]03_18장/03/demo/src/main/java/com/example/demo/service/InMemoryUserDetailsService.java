package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class InMemoryUserDetailsService implements UserDetailsService {

    public final List<UserDetails> users;

    public InMemoryUserDetailsService(List<UserDetails> users) {
        this.users = users;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.stream()
                .filter( //사용자의 목록에서 요청된 사용자 이름과 일치하는 항목을 필터링
                        u -> u.getUsername().equals(username)
                )
                .findFirst() //일치하는 사용자가 있으면 반환
                .orElseThrow(
                        () -> new UsernameNotFoundException("User not found")
                );
    }
}
