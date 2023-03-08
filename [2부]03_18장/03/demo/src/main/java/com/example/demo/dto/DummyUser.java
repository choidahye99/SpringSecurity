package com.example.demo.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class DummyUser implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(()->"READ");
    }


    //이름이 bill이고 비밀번호가 12345인 User 구현

    @Override
    public String getPassword() {
        return "12345";
    }

    @Override
    public String getUsername() {
        return "bill";
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
