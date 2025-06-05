package com.assignment.blogappservice.services;

import com.assignment.blogappservice.models.Token;
import com.assignment.blogappservice.models.User;

public interface UserService
{
    User signUp(String name, String email, String password);
    Token login(String email, String password);
    void logout(String tokenValue);
    User validateToken(String tokenValue);
}
