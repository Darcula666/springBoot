var app = angular.module('myApp', []);
app.controller('siteCtrl', function($scope, $http) {
    $http.get("http://localhost:8081/girls")
        .then(function (response) {
            $scope.girls = response.data;
        });
});