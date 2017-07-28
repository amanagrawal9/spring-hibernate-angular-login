app.controller('RegistrationCtrl', function ($scope, $http, $state, UserService) {


    /*UserService.current_user().$promise.then(function(result){
        $scope.profile = result.data;
    }, function(error) {
        //error code
    });*/

    $scope.user = {};
    $scope.register = function () {
        UserService.register($scope.user).$promise.then(function(data){
            alert("regiter sucess");
        }, function(error){
            console.log("Error");
        });
    }

});