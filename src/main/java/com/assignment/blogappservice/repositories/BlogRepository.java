package com.assignment.blogappservice.repositories;

import com.assignment.blogappservice.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long>
{

}
