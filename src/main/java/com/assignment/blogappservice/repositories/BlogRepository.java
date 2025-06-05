package com.assignment.blogappservice.repositories;

import com.assignment.blogappservice.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long>
{
    Blog save(Blog blog);
    List<Blog> findAll();
}
