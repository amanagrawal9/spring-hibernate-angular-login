app.controller('ScatterChartCtrl', function($scope, $state) {

	$scope.goToDetail = function(){
		$state.go("detail-view");
	}

	$scope.options = {
		chart : {
			type : 'scatterChart',
			height : 400,
			width : 500,
			color : d3.scale.category10().range(),
			scatter : {
				onlyCircles : false
			},
			showDistX : true,
			showDistY : true,
			tooltip : {
				data : 'asdasd',
				//headerEnabled: false,
				contentGenerator : function(data) {
					//console.log(data);
					return '<div class="panel panel-primary">' +
								'<div class="panel-heading">' +
									'<h2 class="panel-title">Aman Agrawal</h2>' +
								'</div>' +
								'<div class="panel-body">' +
									'Efficiency: ' + data.point.x + ' %<br/>' +
									'Duration: ' + data.point.y + ' mins<br/>' +
									'Sleep Segment: ' + 34 + '<br/>' +
									'Start: ' + 'Mon 3, 2016 - 22:00' + '<br/>' +
									'End: ' + 'Tue 4, 2016 - 07:00' + '<br/>' +
								'</div>' +
							'<div>';
				},
				keyFormatter : function(key) {
					return key;
				},
				headerFormatter : function(d) {
					return d;
				}
			},
			duration : 5000,
			clipEdge : true,
			forceX : [ 0, 1 ],
			forceY : [ 0 ],
			interactive : true,
			showLabels : true,
			xAxis : {
				axisLabel : 'Efficiency (%)',
				tickFormat : function(d) {
					return d3.format('.02f')(d);
				},
				fontSize : 40,
				axisLabelDistance : 10
			},
			yAxis : {
				axisLabel : 'Duration (min)',
				tickFormat : function(d) {
					return d3.format('.02f')(d);
				},
				axisLabelDistance : -5
			},
			zoom : {
				//NOTE: All attributes below are optional
				enabled : false,
				scaleExtent : [ 1, 10 ],
				useFixedDomain : false,
				useNiceScale : false,
				horizontalOff : false,
				verticalOff : false,
				unzoomEventType : 'dblclick.zoom'
			}
		}
	};

	$scope.data = [ {
		"key" : "User 1",
		"values" : [ {
			"x" : 0.2,
			"y" : 560,
			"size" : 0.2,
			"shape" : "circle",
			"subject_id" : 6
		}, {
			"x" : 0.4,
			"y" : 860,
			"size" : 0.4,
			"shape" : "circle",
			"subject_id" : 6
		},
	 ]
	}, {
		"key" : "User 2",
		"values" : [ {
			"x" : 0.6,
			"y" : 600,
			"size" : 0.6,
			"shape" : "circle",
			"subject_id" : 6
		}, {
			"x" : 0.8,
			"y" : 400,
			"size" : 0.8,
			"shape" : "circle",
			"subject_id" : 6
		} ]
	} ];
	//console.log(JSON.stringify($scope.data));


});
