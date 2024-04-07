package com.akcodes.swasthma.repositories;

import com.akcodes.swasthma.entities.post.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepo  extends JpaRepository<Comment, Integer> {

    @Query("SELECT c FROM Comment c WHERE c.post.id = :postId")
    List<Comment> findByPostId(Integer postId);
}