package com.assignment.blogappservice.services;

import com.assignment.blogappservice.models.Blog;
import com.assignment.blogappservice.models.User;
import com.assignment.blogappservice.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogRepository blogRepository;
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }
    @Override
    public Blog saveBlog(Blog blog, User user){
        blog.setCreatedAt(new Date());
        blog.setCreatedBy(user);
        return blogRepository.save(blog);
    }
}
