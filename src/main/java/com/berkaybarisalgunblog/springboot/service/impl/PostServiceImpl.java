package com.berkaybarisalgunblog.springboot.service.impl;

import com.berkaybarisalgunblog.springboot.dto.PostDto;
import com.berkaybarisalgunblog.springboot.entity.Post;
import com.berkaybarisalgunblog.springboot.mapper.PostMapper;
import com.berkaybarisalgunblog.springboot.repository.PostRepository;
import com.berkaybarisalgunblog.springboot.service.PostService;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private PostMapper postMapper;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDto> findAllPosts() {

        List<Post> posts=postRepository.findAll();
        return posts.stream().map(PostMapper::mapToPostDto).collect(Collectors.toList());

    }

    @Override
    public void createPost(PostDto postDto) {
        Post post=PostMapper.mapToPost(postDto);
        postRepository.save(post);
    }

    @Override
    public PostDto findPostById(Long postId) {
       Post post=postRepository.findById(postId).get();
       return PostMapper.mapToPostDto(post);
    }

    @Override
    public void updatePost(PostDto postDto) {
        Post post=PostMapper.mapToPost(postDto);
        postRepository.save(post);
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
