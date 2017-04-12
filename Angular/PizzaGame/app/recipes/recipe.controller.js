export class RecipeController {
    constructor(RecipesService, $routeParams) {
        RecipesService.getRecipe($routeParams.id)
            .then(recipe => this.recipe = recipe);
    }
}