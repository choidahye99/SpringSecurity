package com.example.demo.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class DummyUser2 implements UserDetails {

    //더 현실적인 UserDetails 구현

    private final String username;
    private final String password;

    public DummyUser2(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(()->"READ");
    }


    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    //모두 true를 반환 => 사용자가 항상 활성화되고 사용 가능하다는 의미
    @Override
    public boolean isAccountNonExpired() { //계정만료
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { //계정잠금
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { //자격증명만료
        return true;
    }

    @Override
    public boolean isEnabled() { //계정비활성화
        return true;
    }
}
