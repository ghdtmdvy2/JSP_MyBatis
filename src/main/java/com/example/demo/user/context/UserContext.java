package com.example.demo.user.context;

import com.example.demo.user.dao.UserDao;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Getter
public class UserContext extends User {
    private final Long id;
    private final String username;
    public UserContext(UserDao users, List<GrantedAuthority> authorities) {
        super(users.getUsername(), users.getPassword(), authorities);
        this.id = users.getId();
        this.username = users.getUsername();
    }
}
