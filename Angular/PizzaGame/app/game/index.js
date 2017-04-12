import angular from 'angular';
import { GameService } from './game.service'
import { GameController } from './game.controller'

export const GameModule = angular.module('GameModule', [])
    .service('GameService', GameService)
    .controller('GameController', GameController)

    .name;