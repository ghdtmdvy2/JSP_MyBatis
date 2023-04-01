package com.example.demo.user.service;

import com.example.demo.user.context.UserContext;
import com.example.demo.user.dao.UserDao;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.type.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    // 시큐리티가 특정 회원의 username을 받았을 때
    // 그 username에 해당하는 회원정보를 얻는 수단
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDao user = userRepository.findByUsername(new UserDao(username));
        if (user == null) {
            throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
        }

        // 권한들을 담을 빈 리스트를 만든다.
        List<GrantedAuthority> authorities = new ArrayList<>();

        if ("admin".equals(username)) {
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.toString()));
        } else {
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.toString()));
        }

        return new UserContext(user,authorities);
    }
}
