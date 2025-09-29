package mdn.mdn_recipes.domain.validation.strategy.recipe;

import mdn.mdn_recipes.application.dto.recipe.RecipeRequest;
import mdn.mdn_recipes.shared.util.StringHelper;
import org.springframework.stereotype.Component;

@Component
public class RecipeValidateNameImpl implements RecipeValidationStrategy {

    public void validate(RecipeRequest recipe) {

        String name = recipe.name();

        if (StringHelper.isNullOrBlank(name))
            throw new IllegalArgumentException("The recipe's name is required");

        if (name.trim().length() < 3)
            throw new IllegalArgumentException("The recipe's name must be at least 3 characters long");

        if (name.length() > 100)
            throw new IllegalArgumentException("The recipe's name must not exceed 100 characters");

        if (!name.matches("^[\\p{L}\\p{N} .,'-]+$"))
            throw new IllegalArgumentException("The recipe's name contains invalid characters");
    }
}
