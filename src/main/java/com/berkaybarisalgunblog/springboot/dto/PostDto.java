package com.berkaybarisalgunblog.springboot.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PostDto {
    private Long id;
    private String title;
    private String url;
    private String content;
    private String shortDescription;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
