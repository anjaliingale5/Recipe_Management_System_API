package com.Geekster.Recipe_Management_System_API.controller;


import com.Geekster.Recipe_Management_System_API.model.Recipe;
import com.Geekster.Recipe_Management_System_API.model.User;
import com.Geekster.Recipe_Management_System_API.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RecipeController {

    @Autowired
    RecipeService recipeService;


    @PostMapping("recipe")
    public String createRecipe(@Valid @RequestBody Recipe recipe){

        return recipeService.createRecipe(recipe);
    }

   @GetMapping("recipe")
    public List<Recipe> getRecipe(){

        return recipeService.getRecipe();
   }



    @DeleteMapping("deleteRecipe/id/{id}")
    public void deleteRecipe(@PathVariable Long id) {

        recipeService.deleteRecipe(id);
    }

    @PutMapping("recipe/id/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody Recipe updatedRecipe, @RequestHeader("X-Username") String username) {
        Optional<Recipe> optionalRecipe = recipeService.findById(id);

        if (optionalRecipe.isPresent()) {
            Recipe recipe = optionalRecipe.get();
            User owner = recipe.getOwner();

            // Check if the user making the request is the owner of the post
            if (owner.getUsername().equals(username)) {
                recipe.setName(updatedRecipe.getName());
                recipe.setIngredients(updatedRecipe.getIngredients());
                recipe.setInstructions(updatedRecipe.getInstructions());
                Recipe savedRecipe = recipeService.save(recipe);
                return ResponseEntity.ok(savedRecipe);
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}


