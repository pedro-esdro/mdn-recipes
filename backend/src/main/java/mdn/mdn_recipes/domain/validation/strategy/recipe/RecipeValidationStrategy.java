package mdn.mdn_recipes.domain.validation.strategy.recipe;

import mdn.mdn_recipes.application.dto.recipe.RecipeRequest;

public interface RecipeValidationStrategy {
    void validate(RecipeRequest recipe);
}
