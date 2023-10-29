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
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @NotBlank
    private String commentBody;

    @ManyToOne
    @JoinColumn(name = "fk_recipe_id")
    private Recipe recipe;


}
