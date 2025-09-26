package mdn.mdn_recipes.infrastructure.repository;

import mdn.mdn_recipes.domain.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecipeRepository extends JpaRepository<Recipe, UUID> {
}
