var app = angular.module("flikOn", ['ui.router', 'ngResource', 'angular-loading-bar']);

app.config(function ($stateProvider, cfpLoadingBarProvider, $urlRouterProvider) {
    cfpLoadingBarProvider.includeSpinner = true; // Show the spinner.
    cfpLoadingBarProvider.includeBar = true;

    $urlRouterProvider.otherwise("/dashboard");

    $stateProvider
        .state('dashboard', {
            url: "/dashboard",
            templateUrl: 'resources/app/dashboard/dashboard.html'
        });

});
