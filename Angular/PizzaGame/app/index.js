import angular from 'angular';
import ngRoute from 'angular-route';
import { RecipesModule } from './recipes'
import { GameModule } from './game'
import md5 from 'md5';

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
                redirectTo: "play/"
            });
    })

    .controller('StartController', function () {
        console.log('Start controller');
    })

    .controller('DtaGravatarController', function () {
        this.email = md5("renard.cyrille@gmail.com")

        this.action = (email) => {
            console.log('Vous avez cliquez sur le gravatar de ' + email);
        }
    })

    .directive('dtaGravatar', function () {
        return {
            restrict: 'E',
            template: `<img ng-src="https://www.gravatar.com/avatar/{{ctrl.email}}">{{ctrl.email}}`,
            bindToController: {
                myEvent: "&"
            },
            scope: {},
            controller: 'DtaGravatarController',
            controllerAs: 'ctrl'
        }
    })
    ;