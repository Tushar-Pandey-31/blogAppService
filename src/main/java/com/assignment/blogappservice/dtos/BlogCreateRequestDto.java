package com.assignment.blogappservice.dtos;

import com.assignment.blogappservice.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogCreateRequestDto
{
    private String title;
    private String content;
    User user;
}
