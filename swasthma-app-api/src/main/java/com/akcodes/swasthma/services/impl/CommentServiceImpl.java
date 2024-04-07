package com.akcodes.swasthma.services.impl;

import com.akcodes.swasthma.entities.post.Comment;
import com.akcodes.swasthma.entities.post.Post;
import com.akcodes.swasthma.entities.user.User;
import com.akcodes.swasthma.exceptions.ResourceNotFoundException;
import com.akcodes.swasthma.payloads.post.CommentDto;
import com.akcodes.swasthma.payloads.user.UserDto;
import com.akcodes.swasthma.repositories.CommentRepo;
import com.akcodes.swasthma.repositories.PostRepo;
import com.akcodes.swasthma.repositories.UserRepo;
import com.akcodes.swasthma.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId) {
        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "post id ", postId));

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "user id ", userId));

        Comment comment = this.modelMapper.map(commentDto, Comment.class);

        comment.setPost(post);
        comment.setUser(user);
        Comment savedComment = this.commentRepo.save(comment);

        return this.modelMapper.map(savedComment, CommentDto.class);
    }



    @Override
    public void deleteComment(Integer commentId) {
        Comment com = this.commentRepo.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", commentId));
        this.commentRepo.delete(com);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(int postId) {

        Comment comments = commentRepo.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post", "postId", postId));

        List<Comment> commentList= commentRepo.findByPostId(postId);

        List<CommentDto> commentDtoList = commentList.stream()
                .map(comment -> {
                    CommentDto commentDto = modelMapper.map(comment, CommentDto.class);

                    // Map User entity to UserDto
                    UserDto userDto = modelMapper.map(comment.getUser(), UserDto.class);
                    commentDto.setUserDto(userDto);

                    return commentDto;
                })
                .collect(Collectors.toList());

        return commentDtoList;


    }
}
