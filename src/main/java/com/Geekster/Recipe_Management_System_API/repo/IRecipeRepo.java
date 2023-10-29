package com.Geekster.Recipe_Management_System_API.repo;


import com.Geekster.Recipe_Management_System_API.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IRecipeRepo extends JpaRepository<Recipe, Long> {


}
