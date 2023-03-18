package com.berkaybarisalgunblog.springboot.mapper;

import com.berkaybarisalgunblog.springboot.dto.CommentDto;
import com.berkaybarisalgunblog.springboot.entity.Comment;

public class CommentMapper {
    //convert comment entity to comment dto

    public static CommentDto mapToCommentDto(Comment comment){
        return CommentDto.builder()
                .id(comment.getId())
                .name(comment.getName())
                .email(comment.getEmail())
                .content(comment.getContent())
                .createdOn(comment.getCreatedOn())
                .updatedOn(comment.getUpdatedOn())
                .build();
    }

    //convert commentdto to comment entity
    public static Comment maptoComment(CommentDto commentDto){
        return Comment.builder()
                .id(commentDto.getId())
                .name(commentDto.getName())
                .email(commentDto.getEmail())
                .content(commentDto.getContent())
                .createdOn(commentDto.getCreatedOn())
                .updatedOn(commentDto.getUpdatedOn())
                .build();

    }
}
