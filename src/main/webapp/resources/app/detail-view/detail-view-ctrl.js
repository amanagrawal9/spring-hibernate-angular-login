app.controller('DetailViewCtrl', function($scope, $state) {

	$scope.goToDetail = function(){
		$state.go("scatter-chart");
	}

	$scope.data = [ {
			"name": "User 1",
			"x" : 0.2,
			"y" : 560,
			"size" : 0.2,
			"shape" : "circle",
			"subject_id" : 6
		}, {
			"name": "User 1",
			"x" : 0.4,
			"y" : 860,
			"size" : 0.4,
			"shape" : "circle",
			"subject_id" : 6
		},
		{
			"name": "User 2",
			"x" : 0.4,
			"y" : 860,
			"size" : 0.4,
			"shape" : "circle",
			"subject_id" : 6
		}
	];

});
