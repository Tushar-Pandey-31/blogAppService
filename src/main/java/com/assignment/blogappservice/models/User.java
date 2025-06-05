package com.assignment.blogappservice.models;



import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<Blog> blogs;

}

