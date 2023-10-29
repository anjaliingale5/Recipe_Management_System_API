package com.Geekster.Recipe_Management_System_API.service;


import com.Geekster.Recipe_Management_System_API.model.Comment;
import com.Geekster.Recipe_Management_System_API.model.Recipe;
import com.Geekster.Recipe_Management_System_API.repo.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    ICommentRepo commentRepo;

    public List<Comment> getCommentsByRecipe(Recipe recipe) {

        return commentRepo.findByRecipe(recipe);
    }

    public Comment saveComment(Comment comment) {

     return commentRepo.save(comment);

    }
}
