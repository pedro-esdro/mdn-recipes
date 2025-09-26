package mdn.mdn_recipes.domain.validation.strategy.recipe;

import mdn.mdn_recipes.application.dto.recipe.RecipeRequest;
import mdn.mdn_recipes.shared.util.StringHelper;
import org.springframework.stereotype.Component;

@Component
public class RecipeValidateNameImpl implements RecipeValidationStrategy {

    public void validate(RecipeRequest recipe) {

        if (StringHelper.isNullOrBlank(recipe.name()))
            throw new IllegalArgumentException("The recipe's name is required");
    }
}
