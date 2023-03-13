package com.berkaybarisalgunblog.springboot.service.impl;

import com.berkaybarisalgunblog.springboot.controller.PostController;
import com.berkaybarisalgunblog.springboot.dto.PostDto;
import com.berkaybarisalgunblog.springboot.entity.Post;
import com.berkaybarisalgunblog.springboot.mapper.PostMapper;
import com.berkaybarisalgunblog.springboot.repository.PostRepository;
import com.berkaybarisalgunblog.springboot.service.PostService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private PostMapper postMapper;

    private PostController postController;

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
        postDto.setUrl(getUrl(postDto.getTitle()));
        Post post=PostMapper.mapToPost(postDto);
        postRepository.save(post);
    }

    private static String getUrl(String postTitle){


        //oops concepts explained in java
        //oops-concepts-explained-in-java
        String title=postTitle.trim().toLowerCase();
        String url=title.replaceAll("\\s+","-");
        url=url.replaceAll("[^A-Za-z0-9]","-");
        return url;
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public PostDto findPostByUrl(String postUrl) {
        Post post=postRepository.findByUrl(postUrl).get();
        return PostMapper.mapToPostDto(post);
    }

    @Override
    public List<PostDto> searchPosts(String query) {
        List<Post> posts = postRepository.searchPosts(query);
        return posts.stream()
                .map(PostMapper::mapToPostDto)
                .collect(Collectors.toList());
    }


}
