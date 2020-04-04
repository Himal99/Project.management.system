var myapp=angular.module("myApp",[]);

myapp.controller("profilesAjax", function ($scope, $http){
    $scope.getProfiles=function (){
        $http({
            method: "GET",
            url: "/projects/completed"
        }).then(function (response){
            $scope.name=response.name;
             console.log(response);
           
        },function (response){
           
        });
    }
})

 $(document).ready(function () {
    $.getJSON('/projects/completed/', function (data) {
        console.log(data);
    });
})