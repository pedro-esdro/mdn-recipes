package mdn.mdn_recipes.application.controller;

import mdn.mdn_recipes.application.dto.recipe.RecipeRequest;
import mdn.mdn_recipes.domain.service.RecipeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;


@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> create(@RequestBody RecipeRequest recipeRequest) {

        UUID createdId = recipeService.create(recipeRequest);

        return ResponseEntity
                .created(URI.create("/recipes/" + createdId))
                .build();

    }

}
