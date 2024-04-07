package com.akcodes.swasthma.payloads.post;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostResponse {

    private List<PostDto> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean lastPage;
}
