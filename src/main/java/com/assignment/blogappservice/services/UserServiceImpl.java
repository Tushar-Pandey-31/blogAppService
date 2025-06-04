package com.assignment.blogappservice.services;

import com.assignment.blogappservice.models.User;
import com.assignment.blogappservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User signup(String name, String email, String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }

    @Override
    public User login(String email, String password) {

    }
}
