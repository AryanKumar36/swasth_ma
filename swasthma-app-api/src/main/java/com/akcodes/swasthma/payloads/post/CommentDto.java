package com.akcodes.swasthma.payloads.post;

import com.akcodes.swasthma.entities.user.User;
import com.akcodes.swasthma.payloads.user.UserDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentDto {
    private int id;

    private String content;

    private UserDto userDto;
}
