app.controller('LoginCtrl', function ($scope, $http) {

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
});