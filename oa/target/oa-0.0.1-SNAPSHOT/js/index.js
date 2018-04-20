var app = angular.module("myApp",['ngRoute']);

//控制器
app.controller("mycr", function($scope,$rootScope) {
	
	
	
});

//路由
app.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
	
	$routeProvider
		.when('/a', {
			controller: addcvController,
			templateUrl: "addcv.html"
			
		}).when('/cvlist', {
			templateUrl: "cvList.html"
			
		}).when('/selectCv', {
			templateUrl: "selectCv.html"
			
		}).when('/updateCv', {
			templateUrl: "updateCv.html"
			
		}).when('/addleave', {
			templateUrl: "addleave.jsp"
			
		}).when('/leaveList', {
			templateUrl: "leaveList.jsp"
			
		}).when('/selectleave', {
			templateUrl: "selectleave.html"
			
		}).when('/SPleave', {
			templateUrl: "SPleave.html"
			
		}).otherwise({
			templateUrl: "welcome.html"
		});
}]);

//新增
function addcvController($scope){
	
	$scope.closeModal=function(){
		$scope.itemDoc="";
		$scope.itemMoney="";
	}
}
