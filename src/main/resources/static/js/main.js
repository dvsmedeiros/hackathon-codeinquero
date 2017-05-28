angular.module('app', ['ngRoute', 'ngAnimate', 'appServices'])
	.config(function($routeProvider, $locationProvider, $httpProvider) {

		//$locationProvider.html5Mode(true);
		
		//HOME
		$routeProvider.when('/', {
			templateUrl: 'groups.html',
			controller: 'GroupsController'
		});
		
		//GROUPS
		$routeProvider.when('/groups', {
			templateUrl: 'groups.html',
			controller: 'GroupsController'
		});
		
		//GROUP
		$routeProvider.when('/group/:groupId', {
			templateUrl: 'group.html',
			controller: 'GroupController'
		});
		
		//PROFILE
		$routeProvider.when('/profile/:memberId', {
			templateUrl: 'profile.html',
			controller: 'ProfileController'
		});
		
		$routeProvider.otherwise({redirectTo: '/'});		

		$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
	});