export class RecipesController {
    constructor(RecipesService) {
        RecipesService.getToppings()
            .then(toppings => this.toppings = toppings);
    }
}