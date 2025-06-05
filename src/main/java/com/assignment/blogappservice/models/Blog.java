package com.assignment.blogappservice.models;

import jakarta.persistence.*;
import com.assignment.blogappservice.models.User;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Blog extends Base
{
    private String title;

    @Column(length = 5000)
    private String content;

    @ManyToOne (fetch = FetchType.LAZY)
    private User createdBy;
}
