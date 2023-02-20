package com.example.too_all_recipe.Repository;

import com.example.too_all_recipe.Entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity,Long> {
    List<RecipeEntity> findTopByOrderByIdDesc();
}
