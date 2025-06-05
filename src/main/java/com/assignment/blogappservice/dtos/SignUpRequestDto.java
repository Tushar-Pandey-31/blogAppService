package com.assignment.blogappservice.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDto
{
    private String Name;
    private String Email;
    private String Password;
}
