angular.module('app').controller('GroupController', function($scope, $routeParams, groupResource){
	
	$scope.message = '';
	$scope.chat = null;
	
	if($routeParams.groupId) {
		groupResource.get({chatId: $routeParams.groupId}, function(response) {
		$scope.chat = response; 
		}, function(erro) {
			console.log(erro);
		});
	}

});