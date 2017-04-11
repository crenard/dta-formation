import angular from 'angular';
import ngRoute from 'angular-route';
import { UsersModule } from './users';
import { AlertModule } from './alert';

angular.module('app', [
    UsersModule,
    ngRoute,
    AlertModule
])
    .config(function ($locationProvider, $routeProvider) {
        $locationProvider.html5Mode(true);

        $routeProvider
            .when('/users', {
                controller: 'UsersController',
                templateUrl: 'views/users.html',
                controllerAs: 'uctrl'
            })
            .when('/', {
                controller: 'HomeController',
                templateUrl: 'views/home.html',
                controllerAs: 'hctrl'
            })
            .when('/user/:id?', {
                controller: 'UserController',
                templateUrl:'views/user.html',
                controllerAs: 'uctrl'
            })
            .otherwise({
                redirectTo: "/"
            });
    })

    .controller('HomeController', function () {
        this.name = 'Application';
        console.log('Home controller');
    })