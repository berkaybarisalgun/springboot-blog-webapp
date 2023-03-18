package com.berkaybarisalgunblog.springboot.controller;

import com.berkaybarisalgunblog.springboot.dto.CommentDto;
import com.berkaybarisalgunblog.springboot.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //handler method to create form submit request
    @PostMapping("/{postUrl}/comments")
    public String createComment(@PathVariable("postUrl") String postUrl,
                                @ModelAttribute("comment") CommentDto commentDto,
                                Model model){
        commentService.createComment(postUrl,commentDto);
        return "redirect:/post/"+postUrl;


    }
}
