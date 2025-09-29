package mdn.mdn_recipes.domain.validation.strategy.recipe;

import mdn.mdn_recipes.application.dto.recipe.RecipeRequest;
import mdn.mdn_recipes.shared.util.StringHelper;
import org.springframework.stereotype.Component;

@Component
public class RecipeValidateStepsImpl implements  RecipeValidationStrategy{

    public void validate(RecipeRequest recipe) {

        if (recipe.steps() == null || recipe.steps().isEmpty()) {
            throw new IllegalArgumentException("The recipe must have at least one step");
        }

        recipe.steps().forEach(step -> {
            if (StringHelper.isNullOrBlank(step.getDescription())) {
                throw new IllegalArgumentException("Each step must have a description");
            }
            if (step.getDescription().length() < 5) {
                throw new IllegalArgumentException("Each step's description must be at least 5 characters long");
            }
            if (step.getDescription().length() > 500) {
                throw new IllegalArgumentException("Each step's description must not exceed 500 characters");
            }
            if (step.getStepOrder() == null || step.getStepOrder() <= 0) {
                throw new IllegalArgumentException("Each step must have a valid order greater than zero");
            }
        });

    }

}
