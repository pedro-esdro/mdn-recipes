package mdn.mdn_recipes.application.dto.recipe;

import mdn.mdn_recipes.domain.model.Ingredient;
import mdn.mdn_recipes.domain.model.Step;

import java.time.LocalTime;
import java.util.List;

public record RecipeRequest(String name,
                            String description,
                            Integer servings,
                            LocalTime preparationTime,
                            String imagePath,
                            List<Ingredient> ingredients,
                            List<Step> steps
) {}

