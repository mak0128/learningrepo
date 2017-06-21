/**
 * AngularJS application for cardapp.
 * 
 * The [] parameter in the module definition can be used to define dependent modules.
 * Without the [] parameter, you are not creating a new module, but retrieving an existing one.
 */

//var cardapp = angular.module("cardapp", []);

var cardapp = angular.module("cardapp", ["ngRoute"]);

cardapp.config(function($routeProvider) {
	
    $routeProvider.when("/", {
			        templateUrl : "main.html",
			    })
			    .when("/usercarddetail", {
			        templateUrl : "usercard-details.html",
			    })
			    .when("/back", {
			    	templateUrl : "main.html",
			    });
});

cardapp.service('dssrvc', function() {
	this.userclicked = null;
});