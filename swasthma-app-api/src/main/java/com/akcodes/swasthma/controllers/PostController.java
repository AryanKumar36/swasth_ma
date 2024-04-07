package com.akcodes.swasthma.controllers;

import com.akcodes.swasthma.entities.post.Post;
import com.akcodes.swasthma.payloads.ApiResponse;
import com.akcodes.swasthma.payloads.post.PostDto;
import com.akcodes.swasthma.payloads.post.PostResponse;
import com.akcodes.swasthma.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PostController {

    @Autowired
    private PostService postService;

    //create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
                                              @PathVariable Integer userId,
                                              @PathVariable Integer categoryId)
    {

        PostDto createPost= postService.createPost(postDto,userId,categoryId);

        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);

    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId) {

        List<PostDto> posts = this.postService.getPostsByUser(userId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);

    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId) {

        List<PostDto> posts = this.postService.getPostsByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);

    }

    // get all posts

    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPost(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "2", required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = "postId", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir) {

        PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
    }




    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {

        PostDto postDto = this.postService.getPostById(postId);
        return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);

    }

    // delete post
    @DeleteMapping("/posts/{postId}")
    public ApiResponse deletePost(@PathVariable Integer postId) {
        this.postService.deletePost(postId);
        return new ApiResponse("Post is successfully deleted !!", true);
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId) {

        PostDto updatePost = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);

    }

    // search
    @GetMapping("/posts/search/{keywords}")
    public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable("keywords") String keywords) {
        List<PostDto> result = this.postService.searchPosts(keywords);
        return new ResponseEntity<List<PostDto>>(result, HttpStatus.OK);
    }



}


