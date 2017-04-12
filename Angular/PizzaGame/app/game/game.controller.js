export class GameController{
    constructor(GameService, RecipesService){
        this.GameService = GameService;
        this.RecipesService = RecipesService;
        this.pizzas = GameService.pizzas;
        this.RecipesService.getToppings()
            .then(toppings => this.toppings = toppings);
        GameService.start().then(score => {
            console.log('PERDU ! Votre score est : ' + score);
            GameService.score = 0;
        });
        this.pizza = { recipe : 'Choisissez votre recette', toppings: [] };
    }
    
    setPizza(pizza){
        this.pizza = pizza;
    }

    addTopping(topping){
        if (this.pizza){
            this.pizza.toppings.push(topping);
            this.RecipesService.validRecipe(this.pizza)
                .then(status => {
                    console.log(status);
                    this.GameService.validPizza(this.pizza, status)
                });
        }
    }
}