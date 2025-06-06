package com.assignment.blogappservice.dtos;

import com.assignment.blogappservice.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter

@Setter

public class UserDto
{
    private String name;
    private String email;
    private String password;

    public static UserDto from(User user)
    {
        if(user == null)
        {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.name = user.getName();
        userDto.email = user.getEmail();
        userDto.password = user.getPassword();
        return userDto;

    }
}