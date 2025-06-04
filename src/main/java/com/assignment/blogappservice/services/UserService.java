package com.assignment.blogappservice.services;

import com.assignment.blogappservice.models.User;

public interface UserService
{
    User signup(String name, String email, String password);
    User login(String email, String password);
}
