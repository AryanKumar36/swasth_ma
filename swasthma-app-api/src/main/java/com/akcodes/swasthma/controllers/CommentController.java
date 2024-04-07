package com.akcodes.swasthma.controllers;

import com.akcodes.swasthma.payloads.ApiResponse;
import com.akcodes.swasthma.payloads.post.CommentDto;
import com.akcodes.swasthma.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("post/{postId}/user/{userId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment, @PathVariable Integer postId, @PathVariable Integer userId) {

        CommentDto createComment = this.commentService.createComment(comment, postId, userId);
        return new ResponseEntity<CommentDto>(createComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId) {

        this.commentService.deleteComment(commentId);

        return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted successfully !!", true), HttpStatus.OK);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<CommentDto>> getCommentsByPostId(@PathVariable int postId)
    {
        List<CommentDto> comments = commentService.getCommentsByPostId(postId);
        return ResponseEntity.ok(comments);
    }

}
