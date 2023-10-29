package com.Geekster.Recipe_Management_System_API.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeId;

    @NotBlank
    private String recipeName;

    @NotBlank
    private String recipeIngredients;

    @NotBlank
    private String recipeInstructions;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public User getOwner() {
        return user;
    }

    public String getName() {
        return recipeName;
    }

    public String getIngredients() {
        return recipeIngredients;

    }

    public String getInstructions() {
        return recipeInstructions;
    }

    public void setName(String name) {
        recipeName = name;
    }

    public void setIngredients(String ingredients) {
        recipeIngredients = ingredients;
    }

    public void setInstructions(String instructions) {
        recipeInstructions = instructions;
    }
}
