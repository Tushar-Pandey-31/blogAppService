package com.assignment.blogappservice.controllers;

import com.assignment.blogappservice.models.Blog;
import com.assignment.blogappservice.models.User;
import com.assignment.blogappservice.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping
    public ResponseEntity<?> createBlog(@RequestBody Blog blog, User user){
        try{
            Blog createdBlog = blogService.saveBlog(blog, user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBlog);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
