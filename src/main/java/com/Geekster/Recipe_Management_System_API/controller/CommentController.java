package com.Geekster.Recipe_Management_System_API.controller;

import com.Geekster.Recipe_Management_System_API.model.Comment;
import com.Geekster.Recipe_Management_System_API.model.Recipe;
import com.Geekster.Recipe_Management_System_API.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CommentController {

    @Autowired
    CommentService commentService;


    @GetMapping("recipe/{recipe}")
    public List<Comment> getCommentsByRecipe(@PathVariable Recipe recipe) {

        return commentService.getCommentsByRecipe(recipe);
    }

    @PostMapping("comment")
    public Comment saveComment(@Valid @RequestBody Comment comment){

        return commentService.saveComment(comment);
    }
}
