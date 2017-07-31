app.controller('RegistrationCtrl', ['$scope', '$http', '$state', 'UserService', function ($scope, $http, $state, UserService) {

    $scope.user = {};
    $scope.register = function () {
        UserService.register($scope.user).$promise.then(function(data){
            $state.go('login');
        }, function(error){
            console.log("Error");
        });
    }

}]);