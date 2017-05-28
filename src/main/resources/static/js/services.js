angular.module('appServices', ['ngResource'])
	
	.factory('groupResource', function($resource) {
		return $resource('http://localhost:9000/app/chat/:chatId', null, null);
	})
	.factory('memberResource', function($resource) {
		return $resource('http://localhost:9000/app/member/:memberId', null, null);
	})
	;
	