CREATE TABLE recipe (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    servings INT NOT NULL,
    preparation_time TIME NOT NULL,
    image_path TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE ingredient (
    id UUID PRIMARY KEY,
    recipe_id UUID NOT NULL REFERENCES recipe(id) ON DELETE CASCADE,
    name VARCHAR(100) NOT NULL,
    quantity VARCHAR(30) NOT NULL
);

CREATE TABLE step (
    id UUID PRIMARY KEY,
    recipe_id UUID NOT NULL REFERENCES recipe(id) ON DELETE CASCADE,
    description TEXT NOT NULL,
    step_order INT NOT NULL
);

CREATE INDEX idx_ingredient_recipe ON ingredient(recipe_id);
CREATE INDEX idx_step_recipe_order ON step(recipe_id, step_order);
