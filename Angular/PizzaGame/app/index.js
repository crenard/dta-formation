import angular from 'angular';
import ngRoute from 'angular-route';

angular.module('app', [
    ngRoute
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
                templateUrl: 'views/play.html',
                controllerAs: 'gctrl'
            })
            .otherwise({
                redirectTo: "/"
            });
    })

    .controller('StartController', function () {
        console.log('Start controller');
    })
    .controller('GameController', function () {
        console.log('Game controller');
    })