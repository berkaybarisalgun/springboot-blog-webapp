package com.berkaybarisalgunblog.springboot.controller;

import com.berkaybarisalgunblog.springboot.dto.PostDto;
import com.berkaybarisalgunblog.springboot.entity.Post;
import com.berkaybarisalgunblog.springboot.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //creating handler method,GET request and return model and view
    @GetMapping("/admin/posts")
    public String posts(Model model){
        List<PostDto> posts=postService.findAllPosts();
        model.addAttribute("posts",posts);
        return "/admin/posts";
    }
}
