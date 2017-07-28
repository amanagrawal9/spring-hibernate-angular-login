var app = angular.module("loginModule", ['ui.router', 'ngResource', 'angular-loading-bar']);

app.config(function ($stateProvider, cfpLoadingBarProvider, $urlRouterProvider) {
    cfpLoadingBarProvider.includeSpinner = true; // Show the spinner.
    cfpLoadingBarProvider.includeBar = true;

    $urlRouterProvider.otherwise("/");

    $stateProvider
        .state('index', {
            url: "/",
            templateUrl: 'resources/app/login-module/landing.html',
            controller: 'LandingCtrl'
        })
        .state('login', {
            url: "/login",
            templateUrl: 'resources/app/login-module/login.html',
            controller: 'LoginCtrl'
        })
        .state('registration', {
            url: "/registration",
            templateUrl: 'resources/app/login-module/registration.html',
            controller: 'RegistrationCtrl'
        });

});
