"use strict";

(function () {

    angular.module("bd1", ["ui.router"])

        .config(function($stateProvider, $urlRouterProvider){

            $stateProvider
                 .state('index', {
                     url: '/index',
                     templateUrl: 'templates/table-faixas.html',
                     controller: 'FaixaController as vm'
                 });
            
            $urlRouterProvider.otherwise('/index');

        });

})();

