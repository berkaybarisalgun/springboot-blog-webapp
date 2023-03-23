package com.berkaybarisalgunblog.springboot.mapper;

import com.berkaybarisalgunblog.springboot.dto.PostDto;
import com.berkaybarisalgunblog.springboot.entity.Post;

import java.util.stream.Collectors;

public class PostMapper {
    //map Post entitiy to PostDto
    public static PostDto mapToPostDto(Post post){
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .url(post.getUrl())
                .content(post.getContent())
                .shortDescription(post.getShortDescription())
                .createdOn(post.getCreatedOn())
                .updatedOn(post.getUpdatedOn())
                .comments(post.getComments().stream().map((comment)->CommentMapper.mapToCommentDto(comment)).collect(Collectors.toSet()))
                .build();

    }

    //map Postdto to Post entity
    public static Post mapToPost(PostDto postDto){
        return Post.builder()
                .id(postDto.getId())
                .title(postDto.getTitle())
                .url(postDto.getUrl())
                .content(postDto.getContent())
                .shortDescription(postDto.getShortDescription())
                .createdOn(postDto.getCreatedOn())
                .updatedOn(postDto.getUpdatedOn())
                .build();

    }
}
