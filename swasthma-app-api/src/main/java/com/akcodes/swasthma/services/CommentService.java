package com.akcodes.swasthma.services;

import com.akcodes.swasthma.entities.post.Comment;
import com.akcodes.swasthma.payloads.post.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, Integer postId, Integer UserId);

    void deleteComment(Integer commentId);

    List<CommentDto> getCommentsByPostId(int postId);

}
