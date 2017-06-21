/**
 * cardapp's controller
 */

cardapp.controller("userListController", function($scope, $http, dssrvc){
	$http.get("/cardapp/restapi/users")
		 .then(function (response) {
			$scope.users = response.data;
		 });
	

	
	$scope.clickUser = function(username) {
		dssrvc.userclicked = username;
	};
});


cardapp.controller("userCardDetail", function($scope, $http, dssrvc){
	$http.get("/cardapp/restapi/"+dssrvc.userclicked)
	 .then(function (response) {
		$scope.usercarddetail = response.data;
	 });
	
	
});
