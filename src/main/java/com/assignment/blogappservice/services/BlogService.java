package com.assignment.blogappservice.services;

import com.assignment.blogappservice.dtos.BlogResponseDto;
import com.assignment.blogappservice.models.Blog;
import com.assignment.blogappservice.models.User;

import java.util.List;

public interface BlogService
{

    Blog saveBlog(Blog blog, User user);
    List<Blog> getAllBlog();
    Blog createBlog(String title, String content, User user);
}
