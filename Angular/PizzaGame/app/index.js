import angular from 'angular';
import ngRoute from 'angular-route';
import { RecipesModule } from './recipes'
import { GameModule } from './game'
import md5 from 'md5';
import { PizzasDirective } from "./pizzas.directive"

angular.module('app', [
    ngRoute,
    RecipesModule,
    GameModule
])
    .config(function ($locationProvider, $routeProvider) {
        $locationProvider.html5Mode(true);

        $routeProvider
            .when('/', {
                controller: 'StartController',
                templateUrl: 'views/start.html',
                controllerAs: 'gctrl'
            })
            .when('/play', {
                controller: 'GameController',
                templateUrl: 'views/game.html',
                controllerAs: 'gctrl'
            })
            .when('/recipe/:id', {
                controller: 'RecipeController',
                templateUrl: 'views/recipe.html',
                controllerAs: 'rctrl'
            })
            .otherwise({
                redirectTo: 'play/'
            });
    })

    .controller('StartController', function () {
        console.log('Start controller');
    })

    .directive('dtaPizzas', PizzasDirective)

    ;