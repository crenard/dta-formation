import angular from 'angular';
import { RecipeController } from './recipe.controller'
import { RecipesService } from './recipe.service'

export const RecipesModule = angular.module('RecipesModule', [])
    .value('API_URL', 'http://localhost:3000')
    .service('RecipesService', RecipesService)
    .controller('RecipeController', RecipeController)

    .name;