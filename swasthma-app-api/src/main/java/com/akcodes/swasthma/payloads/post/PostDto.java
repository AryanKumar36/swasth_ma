package com.akcodes.swasthma.payloads.post;


import com.akcodes.swasthma.entities.post.Category;
import com.akcodes.swasthma.entities.post.Comment;
import com.akcodes.swasthma.entities.user.User;
import com.akcodes.swasthma.payloads.user.UserDto;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class PostDto {

    private String title;
    private String content;
    private String postImageUrl;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;
}