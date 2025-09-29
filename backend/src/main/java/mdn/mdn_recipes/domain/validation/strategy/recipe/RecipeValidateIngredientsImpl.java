package mdn.mdn_recipes.domain.validation.strategy.recipe;

import mdn.mdn_recipes.application.dto.recipe.RecipeRequest;
import mdn.mdn_recipes.domain.model.Ingredient;
import mdn.mdn_recipes.shared.util.StringHelper;
import org.springframework.stereotype.Component;

@Component
public class RecipeValidateIngredientsImpl implements  RecipeValidationStrategy {

    public void validate(RecipeRequest recipe) {

        if (recipe.ingredients() == null || recipe.ingredients().isEmpty()) {
            throw new IllegalArgumentException("The recipe must have at least one ingredient");
        }

        recipe.ingredients().forEach(this::validateIngredient);
    }

    private void validateIngredient(Ingredient ingredient) {

        if (ingredient.getName() == null || ingredient.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Each ingredient must have a name");
        }
        if (ingredient.getName().length() < 2) {
            throw new IllegalArgumentException("Each ingredient's name must be at least 2 characters long");
        }
        if (ingredient.getName().length() > 100) {
            throw new IllegalArgumentException("Each ingredient's name must not exceed 100 characters");
        }
        if (StringHelper.isNullOrBlank(ingredient.getQuantity())) {
            throw new IllegalArgumentException("Each ingredient must have a quantity");
        }
        if (ingredient.getQuantity().isEmpty()) {
            throw new IllegalArgumentException("Each ingredient's quantity must be at least 1 character long");
        }
        if (ingredient.getQuantity().length() > 50) {
            throw new IllegalArgumentException("Each ingredient's quantity must not exceed 50 characters");
        }

        String quantity = ingredient.getQuantity();
        if (!quantity.matches(".*[A-Za-z].*") || !quantity.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Each ingredient's quantity must contain at least one letter and one number");
        }
    }
}
