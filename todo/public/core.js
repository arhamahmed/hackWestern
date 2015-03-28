var scotchTodo = angular.module('scotchTodo', []);

function mainController($scope, $http) {
	$scope.formData = {};
	$scope.favs = false;
	
	var textHold = "plsssssss";
	var queryHold = "";
	var doneHold = false;
	var titleScoresHold = [];
	var sizeScoresHold = [];
	var obj = {text: textHold, query: queryHold, done: doneHold, titleScores: titleScoresHold, sizeScores: sizeScoresHold};
	//$scope.titleScores = ['title1: abc', 'title2: def', 'title3: ghi'];
	//$scope.sizeScores = ['size1: hi'];

	// when landing on the page, get all todos and show them
	$http.get('/api/todos')
		.success(function(data) {
			$scope.todos = data;
		})
		.error(function(data) {
			console.log('Error: ' + data);
		});

	// when submitting the add form, send the text to the node API
	$scope.createTodo = function() {
		$http.post('/api/todos', {text:'test',query:'bleh',done: false, titleScores: $scope.titleScores, sizeScores: ["url2: 1"]})
			.success(function(data) {
				$scope.formData = {}; // clear the form so our user is ready to enter another
				$scope.todos = data;
				console.log(data);
			})
			.error(function(data) {
				console.log('Error: ' + data);
			});
	};
	
	$scope.addCustomTodo = function() {
		$http.post('/api/todos', obj)
			.success(function(data) {
				$scope.formData = {}; // clear the form so our user is ready to enter another
				$scope.todos = data;
				console.log(data);
			})
			.error(function(data) {
				console.log('Error: ' + data);
			});
	};

	// delete a todo after checking it
	$scope.deleteTodo = function(id) {
		$http.delete('/api/todos/' + id)
			.success(function(data) {
				$scope.todos = data;
			})
			.error(function(data) {
				console.log('Error: ' + data);
			});
	};
	
	$scope.addTodo = function(id) {
		$scope.todos.push({text:'',query:'',done: false, titlescores: [], sizescores: []});
	};
	
	$scope.addToFav = function() {
		$scope.favs = true;
		
		console.log("" + $scope.favs + " " + $scope.todos.data);
	}
	
	$scope.patchSizes = function(id) {
		$scope.deleteTodo(id);
		//reinitialize obj
		$scope.addCustomTodo();
	};
	
	$scope.patchTitles = function(id) {
		$scope.deleteTodo(id);
		//reinitialize obj
		$scope.addCustomTodo();
	};

}
