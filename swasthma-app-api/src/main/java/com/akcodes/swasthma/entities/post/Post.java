package com.akcodes.swasthma.entities.post;

import com.akcodes.swasthma.entities.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false)
    private int postId;
    @Column(name = "post_title", length = 100, nullable = false)
    private String title;

    @Column(length = 1000000000)
    private String content;

    private String postImageUrl;

    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();


}