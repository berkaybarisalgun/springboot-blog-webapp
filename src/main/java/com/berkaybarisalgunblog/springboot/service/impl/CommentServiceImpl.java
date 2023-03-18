package com.berkaybarisalgunblog.springboot.service.impl;

import com.berkaybarisalgunblog.springboot.dto.CommentDto;
import com.berkaybarisalgunblog.springboot.entity.Comment;
import com.berkaybarisalgunblog.springboot.entity.Post;
import com.berkaybarisalgunblog.springboot.mapper.CommentMapper;
import com.berkaybarisalgunblog.springboot.repository.CommentRepository;
import com.berkaybarisalgunblog.springboot.repository.PostRepository;
import com.berkaybarisalgunblog.springboot.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;


    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void createComment(String postUrl, CommentDto commentDto) {
        Post post=postRepository.findByUrl(postUrl).get();
        Comment comment= CommentMapper.maptoComment(commentDto);
        comment.setPost(post);
        commentRepository.save(comment);
    }
}
