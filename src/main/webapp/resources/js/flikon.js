var app = angular.module("loginModule", ['ui.router', 'ngResource', 'angular-loading-bar']);

app.config([ '$stateProvider', 'cfpLoadingBarProvider', '$urlRouterProvider',
    function ($stateProvider, cfpLoadingBarProvider, $urlRouterProvider) {
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

}]);
;app.service('UserService', ['$resource', function($resource) {
	return $resource('/flikon/:id/:operation', {
		id: '@id',
		operation: '@operation'
	}, {
		current_user: {
			method: 'GET',
			params: {
				operation: 'current_user'
			},
			isArray: false
		},
        register: {
            method: 'POST',
            params: {
                operation: 'register'
            },
            isArray: false
        }
	});
	
}]);;app.controller('LandingCtrl', ['$scope', function ($scope) {
	

	
}]);;app.controller('LoginCtrl', ['$scope', '$http', function ($scope, $http) {

    $scope.user = {};
    $scope.login = function () {

        $http.post('login', $.param($scope.user), {
            headers : {
                "content-type" : "application/x-www-form-urlencoded"
            }
        }).success(function(data) {
            window.location.href = "/flikon";
            console.log("Sucess Login");
        }).error(function(data) {
            console.log("Fail Login");
        })
    }
}]);;app.controller('RegistrationCtrl', ['$scope', '$http', '$state', 'UserService', function ($scope, $http, $state, UserService) {

    $scope.user = {};
    $scope.register = function () {
        UserService.register($scope.user).$promise.then(function(data){
            $state.go('login');
        }, function(error){
            console.log("Error");
        });
    }

}]);