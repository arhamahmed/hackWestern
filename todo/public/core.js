var scotchTodo = angular.module('scotchTodo', []);
//var tS = ['title1: abc', 'title2: def', 'title3: ghi'];
//var sS = ['size1: hi'];
//var uS = ['url1: u1', 'url2: u2'];

function mainController($scope, $http) {
	$scope.formData = {};
	$scope.favs = false;
	//scope.titleScores = ['title1: abc', 'title2: def', 'title3: ghi'];
	//$scope.sizeScores = ['size1: hi'];
	//$scope.urlScores = ['url1: u1', 'url2: u2'];

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
		$http.post('/api/todos', $scope.formData)
			.success(function(data) {
				$scope.formData = {}; // clear the form so our user is ready to enter another
				$scope.todos = data;
				//$scope.todos.urlScores = ["url1: u1", "url2: u2"];
				//$scope.todos.sizeScores = ["size1: hi"];
				//$scope.todos.titleScores = ["title1: abc", "title2: def", "title3: ghi"];
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
		$scope.todos.push({text:'',query:''});
	};
	
	$scope.addToFav = function() {
		$scope.favs = true;
		
		console.log("" + $scope.favs + " " + $scope.todos.data);
	}

}
