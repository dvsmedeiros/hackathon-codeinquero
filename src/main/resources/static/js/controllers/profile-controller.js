angular.module('app').controller('ProfileController', function($scope, $routeParams, memberResource){
	
	$scope.message = '';
	$scope.member = {};
	
	if($routeParams.memberId) {
		memberResource.get({memberId: $routeParams.memberId}, function(response) {
		$scope.member = response; 
		}, function(erro) {
			console.log(erro);
		});
	}
		
});