package com.akcodes.swasthma.entities.user;

import com.akcodes.swasthma.entities.post.Comment;
import com.akcodes.swasthma.entities.post.Post;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private int userId;

    @NotBlank(message = "First name is mandatory")
    @Size(max = 50, message = "First name cannot exceed 50 characters")
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;


    @NotBlank(message = "Last name is mandatory")
    @Size(max = 50, message = "Last name cannot exceed 50 characters")
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @NotBlank(message = "Username is mandatory")
    @Column(unique = true)
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    @Size(max = 255)
    @Column(name = "profile_picture_url", length = 255)
    private String profilePictureUrl;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    private String phoneNo;

    @NotNull
    @Past
    @Temporal(TemporalType.DATE)
    @Column(name = "DateOfBirth", nullable = false)
    private Date DateOfBirth;

    @NotBlank
    @Size(max = 10)
    @Column(name = "gender", nullable = false, length = 10)
    private String gender;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts= new ArrayList<>();


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();
}