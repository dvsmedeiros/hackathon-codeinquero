angular.module('app').controller('GroupsController', function($scope, groupResource){
	
	$scope.message = '';
	$scope.chats = [];
	
	groupResource.query(function(response){
		$scope.chats = response;
	}, function(erro){
		console.log(erro);
	});
});