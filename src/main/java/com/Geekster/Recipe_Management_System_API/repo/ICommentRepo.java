package com.Geekster.Recipe_Management_System_API.repo;

import com.Geekster.Recipe_Management_System_API.model.Comment;
import com.Geekster.Recipe_Management_System_API.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentRepo extends JpaRepository<Comment, Long> {

    List<Comment> findByRecipe(Recipe recipe);
}
