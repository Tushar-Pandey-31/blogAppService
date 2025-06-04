package com.assignment.blogappservice.services;

import com.assignment.blogappservice.models.Blog;
import com.assignment.blogappservice.models.User;

public interface BlogService
{

    Blog saveBlog(Blog blog, User user);
}
