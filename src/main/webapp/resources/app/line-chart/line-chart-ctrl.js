app.controller('LineChartCtrl', function ($scope) {
	
	function generateOptions(yaxisLabel) {
		var options = {
	            chart: {
	                type: 'lineChart',
	                height: 200,
	                margin : {
	                    top: 20,
	                    right: 20,
	                    bottom: 40,
	                    left: 55
	                },
	                x: function(d){ return d.x; },
	                y: function(d){ return d.y; },
	                useInteractiveGuideline: true,
	                dispatch: {
	                    stateChange: function(e){ console.log("stateChange"); },
	                    changeState: function(e){ console.log("changeState"); },
	                    tooltipShow: function(e){ console.log("tooltipShow"); },
	                    tooltipHide: function(e){ console.log("tooltipHide"); }
	                },
	                xAxis: {
	                	axisLabel: 'Sleep Date',
	                	axisLabelDistance: -20,
	                    tickFormat: function(d) {
	                        return d3.time.format('%d/%m/%Y')(new Date(d))
	                    },
	                    rotateLabels: -10
	                },
	                yAxis: {
	                    axisLabel: yaxisLabel,
	                    tickFormat: function(d){
	                        return d3.format('r')(d);
	                    },
	                    axisLabelDistance: -20
	                }
	            }
	        };
		return options;
	}
	
	function randomChartData() {
		var userData = [];
		var oldDate = new Date(2012, 0, 1);
		var currentDate = new Date(2016, 9, 1);
		while(oldDate.getTime() < currentDate.getTime()){
			var node = {
					x : oldDate.getTime(),
					y : Math.floor((Math.random() * 100) + 1)
				};
			userData.push(node);
			oldDate.setMonth(oldDate.getMonth() + 4);
		}
		
		return userData;
	}
	

        function randomData() {
        	var user1Data = randomChartData();
        	var user2Data = randomChartData();
            return [
                {
                    values: user1Data,
                    key: 'User 1',
                    color: 'blue'
                },
                {
                    values: user2Data,
                    key: 'User 2',
                    color: 'brown'
                }
            ];
        };
        $scope.options1 = generateOptions('Sleep Efficiency');
        $scope.data1 = randomData();
        
        $scope.options2 = generateOptions('Total Time in Bed (Minutes)');
        $scope.data2 = randomData();
        
        $scope.options3 = generateOptions('Sleep Duration (Minutes)');
        $scope.data3 = randomData();
	
});
