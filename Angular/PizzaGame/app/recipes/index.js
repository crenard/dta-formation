import angular from 'angular';
import { RecipesController } from './recipes.controller'
import { RecipeController } from './recipe.controller'
import { RecipesService } from './recipe.service'

export const RecipesModule = angular.module('RecipesModule', [])
    .value('API_URL', 'http://localhost:3000')
    .service('RecipesService', RecipesService)
    .controller('RecipesController', RecipesController)
    .controller('RecipeController', RecipeController)

    .name;