import { uniq } from 'lodash';

let cacheRecipes;
export class RecipeService {
    getToppings() {
        return this.getRecipes()
            .then(this._extractToppings);
    }

    getRecipes() {
        if (!cacheRecipes) {
            cacheRecipes = fetch('http://localhost:3000/recipes')
                .then(resp => resp.json())
        }
        return cacheRecipes;
    }

    _extractToppings(recipes) {
        return uniq(recipes.reduce((acc, recipe) =>
            [...acc, ...recipe.toppings]
            , []))
    }

    getRandomRecipe() {
        return this.getRecipes().then(resp => resp[Math.floor(Math.random() * resp.length)]
        )
    }

    getRecipe(name) {
        return this.getRecipes()
            .then(recipes => recipes.find(recipe => recipe.name === name));
    }
}
