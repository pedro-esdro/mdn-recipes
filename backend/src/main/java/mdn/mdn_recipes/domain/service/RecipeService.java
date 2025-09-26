package mdn.mdn_recipes.domain.service;

import jakarta.transaction.Transactional;
import mdn.mdn_recipes.application.dto.recipe.*;
import mdn.mdn_recipes.domain.model.Recipe;
import mdn.mdn_recipes.domain.validation.strategy.recipe.RecipeValidationStrategy;
import mdn.mdn_recipes.infrastructure.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class RecipeService {

    private final List<RecipeValidationStrategy> recipeValidationStrategyList;
    private final RecipeRepository recipeRepository;

    public RecipeService(
            List<RecipeValidationStrategy> recipeValidationStrategyList,
            RecipeRepository recipeRepository
    ) {
        this.recipeValidationStrategyList = recipeValidationStrategyList;
        this.recipeRepository = recipeRepository;
    }

    public UUID create(RecipeRequest recipeRequest) {

        recipeValidationStrategyList.forEach(
                strategy -> strategy.validate(recipeRequest));

        Recipe recipe = Recipe.fromDTO(recipeRequest);

        return recipeRepository.save(recipe).getId();
    }

}
