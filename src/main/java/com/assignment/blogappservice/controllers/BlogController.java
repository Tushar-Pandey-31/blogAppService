package com.assignment.blogappservice.controllers;

import com.assignment.blogappservice.dtos.BlogCreateRequestDto;
import com.assignment.blogappservice.dtos.BlogResponseDto;
import com.assignment.blogappservice.models.Blog;
import com.assignment.blogappservice.models.User;
import com.assignment.blogappservice.repositories.BlogRepository;
import com.assignment.blogappservice.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/api/blogs")
public class BlogController {
    @Autowired
    BlogService blogService;
    BlogRepository blogRepository;

    public BlogController(BlogService blogService, BlogRepository blogRepository) {
        this.blogService = blogService;
        this.blogRepository = blogRepository;
    }

    @PostMapping("/blogs")
    public BlogResponseDto createBlog(@RequestBody BlogCreateRequestDto blogCreateRequestDto)
    {
        Blog blog = blogService.createBlog(
                blogCreateRequestDto.getTitle(),
                blogCreateRequestDto.getContent(),
                blogCreateRequestDto.getUser()
        );
        BlogResponseDto blogResponseDto = BlogResponseDto.from(blog);
        return blogResponseDto;

    }
    @GetMapping("/")
    public List<BlogResponseDto> getAllBlog()
    {
            List<Blog> blogs = blogService.getAllBlog();
            List<BlogResponseDto> blogResponseDtos = new ArrayList<>();
            for(Blog blog : blogs){
                BlogResponseDto blogResponseDto = BlogResponseDto.from(blog);
                blogResponseDtos.add(blogResponseDto);
            }
            return blogResponseDtos;

    }

}
