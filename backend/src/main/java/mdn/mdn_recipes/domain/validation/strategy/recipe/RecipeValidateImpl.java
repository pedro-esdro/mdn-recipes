package mdn.mdn_recipes.domain.validation.strategy.recipe;

import mdn.mdn_recipes.application.dto.recipe.RecipeRequest;

import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class RecipeValidateImpl implements RecipeValidationStrategy {

    public void validate(RecipeRequest recipe) {

        Integer servings = recipe.servings();
        LocalTime preparationTime = recipe.preparationTime();

        if (servings == null || servings <= 0)
            throw new IllegalArgumentException("The recipe's servings must be greater than zero");

        if (preparationTime == null || preparationTime.equals(LocalTime.MIDNIGHT))
            throw new IllegalArgumentException("The recipe's preparation time must be greater than zero");

    }
}
