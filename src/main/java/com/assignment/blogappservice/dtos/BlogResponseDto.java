package com.assignment.blogappservice.dtos;

import com.assignment.blogappservice.models.Blog;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BlogResponseDto
{
    private long id;
    private String title;
    private String content;
    private String author;
    private Date createdAt;

    public static BlogResponseDto from(Blog blog) {
        BlogResponseDto blogResponseDto = new BlogResponseDto();
        blogResponseDto.setId(blog.getId());
        blogResponseDto.setTitle(blog.getTitle());
        blogResponseDto.setContent(blog.getContent());
        blogResponseDto.setAuthor(String.valueOf(blog.getCreatedBy()));
        blogResponseDto.setCreatedAt(blog.getCreatedAt());

        return blogResponseDto;
    }

}
