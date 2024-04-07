package com.akcodes.swasthma.services;

import com.akcodes.swasthma.payloads.post.PostDto;
import com.akcodes.swasthma.payloads.user.UserDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface CloudinaryImageService {

    public UserDto upload(MultipartFile file, Integer userId);

    public PostDto mediaUpload(MultipartFile file, Integer postId);
}
