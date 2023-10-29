package com.Geekster.Recipe_Management_System_API.service;


import com.Geekster.Recipe_Management_System_API.model.Recipe;
import com.Geekster.Recipe_Management_System_API.repo.IRecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    IRecipeRepo recipeRepo;

    public String createRecipe(Recipe recipe) {

        recipeRepo.save(recipe);
        return "Recipe Added";
    }

    public List<Recipe> getRecipe() {

        return recipeRepo.findAll();
    }


    public Recipe updateRecipe(Long id, Recipe recipe) {

        boolean recip1 = recipeRepo.existsById(id);
        if(recip1){
            recipeRepo.save(recipe);
        }
        return recipe;
    }

    public void deleteRecipe(Long id) {

            recipeRepo.findById(id);
    }

    public Optional<Recipe> findById(Long id) {
        return recipeRepo.findById(id);
    }

    public Recipe save(Recipe recipe) {

        return recipeRepo.save(recipe);
    }
}
