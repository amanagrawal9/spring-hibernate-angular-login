var app = angular.module("flikOn", ['ui.router', 'ngResource', 'angular-loading-bar', 'nvd3']);

app.config(function ($stateProvider, cfpLoadingBarProvider, $urlRouterProvider) {
    cfpLoadingBarProvider.includeSpinner = true; // Show the spinner.
    cfpLoadingBarProvider.includeBar = true;

    $urlRouterProvider.otherwise("/list-charts");

    $stateProvider
        .state('scatter-chart', {
            url: "/scatter-chart",
            templateUrl: 'resources/app/scatter-chart/scatter-chart.html',
            controller: 'ScatterChartCtrl'
        })
        .state('line-chart', {
            url: "/line-chart",
            templateUrl: 'resources/app/line-chart/line-chart.html',
            controller: 'LineChartCtrl'
        })
        .state('list-charts', {
            url: "/list-charts",
            templateUrl: 'resources/app/list-chart.html'
        })
        .state('detail-view', {
            url: "/detail-view",
            templateUrl: 'resources/app/detail-view/detail-view.html',
            controller: 'DetailViewCtrl'
        });

});
