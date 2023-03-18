package com.berkaybarisalgunblog.springboot.service;

import com.berkaybarisalgunblog.springboot.dto.CommentDto;

public interface CommentService {
    void createComment(String postUrl, CommentDto commentDto);
}
