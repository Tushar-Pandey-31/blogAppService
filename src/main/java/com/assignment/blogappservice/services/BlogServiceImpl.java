package com.assignment.blogappservice.services;

import com.assignment.blogappservice.dtos.BlogResponseDto;
import com.assignment.blogappservice.models.Blog;
import com.assignment.blogappservice.models.User;
import com.assignment.blogappservice.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    @Override
    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public Blog createBlog(String title, String content, User user) {
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setCreatedBy(user);
        blog.setCreatedAt(new Date());
        return blogRepository.save(blog);
    }
}
