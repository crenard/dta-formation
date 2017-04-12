import { uniq } from 'lodash';

let cacheRecipes;
export class RecipesService {
    constructor($http, API_URL, $q) {
        this.$http = $http;
        this.API_URL = `${API_URL}/recipes`;
        this.$q = $q;
    }

    getRecipe(id) {
        return this.$http.get(`${this.API_URL}/${id}`)
            .then(resp => resp.data);
    }

    getRecipes() {
        if (!this.cacheRecipes) {
            this.cacheRecipes = this.$http.get(`${this.API_URL}`)
                .then(resp => resp.data);
        }
        return this.cacheRecipes;
    }

    getToppings() {
        return this.getRecipes()
            .then(this._extractToppings);
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

    validRecipe(pizza) {
        return this.getRecipe(pizza.recipe)
            .then(recipe => {
                let res = recipe.toppings.reduce(
                    (acc, topping) => {
                        let first = pizza.toppings.indexOf(topping);
                        let last = pizza.toppings.lastIndexOf(topping);

                        if (first !== -1 && first === last) acc.ok++;
                        else acc.ko++;
                        return acc;
                    },
                    { ok: 0, ko: 0 }
                );

                if (res.ok < pizza.toppings.length) return "WRONG";
                else if (res.ko > 0) return "INCOMPLETE";
                else return "COMPLETE";
            })
    }
}
