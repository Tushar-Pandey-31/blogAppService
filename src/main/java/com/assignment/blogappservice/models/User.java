package com.assignment.blogappservice.models;



import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
public class User extends Base
{
    private String name;
    private String email;
    private String password;

    private List<Blog> blogs;
}

