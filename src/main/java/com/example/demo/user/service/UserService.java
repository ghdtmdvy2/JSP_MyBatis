package com.example.demo.user.service;

import com.example.demo.user.dao.UserDao;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public void create(String username, String password) {
        UserDao userDao = new UserDao();
        userDao.setUsername(username);
        userDao.setPassword(passwordEncoder.encode(password));
        userRepository.create(userDao);
    }
}
