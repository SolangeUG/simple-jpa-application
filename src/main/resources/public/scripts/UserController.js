'use strict'

/**
 * AngularJS Controller
 */
var app = angular.module('app', [])

.controller('UserController', function($scope, $http) {

    /**
     * Controller initialization
     */
	$scope.userService = "http://localhost:8080/app/users";
	$scope.roleService = "http://localhost:8080/app/roles";

	$scope.showListUsers = true;
	$scope.showPhoto = false;
	$scope.photo = false;
	$scope.showDivs = function(userList) {
		if (userList) {
			$scope.showNewForm = false;
			$scope.showListUsers = true;
		} else {
			$scope.formTitle = "Add New User"
			$scope.id = "";
			$scope.firstName = "";
			$scope.lastName = "";
			$scope.userName = "";
			$scope.showPhoto = false;
			angular.element(document.getElementById("pic")).val(null);
			$scope.showNewForm = true;
			$scope.showListUsers = false;
		}
	}

    /**
     * Reset the user creation form
     */
	$scope.reset = function(form) {
        if (form) {
          form.$setPristine();
          form.$setUntouched();
        }
    };

    /**
     * Get role list
     */
    $scope.getRoles = function() {
        $http.get($scope.roleService)
            .then(function(response) {
                $scope.roles = {
                    selectedOptions: {},
                    availableOptions: response.data
                };
            });
        $scope.searchText = "";
    }

	/**
	 * Get user list
	 */
	$scope.getUsers = function() {
		$http.get($scope.userService)
		    .then(function(response) {
				$scope.users = response.data;
            });
		$scope.searchText = "";
	}

	/**
     * Get user by their id
     */
	$scope.getUserById = function(id) {
		$http.get($scope.userService + "/id/" + id)
		    .then(function(response) {
				$scope.user = response.data;
				$scope.showDetail();
			});
		$scope.searchText = "";
	}

	/**
     * Add/Update a user
     */
	$scope.submitUser = function() {

		var addUser = {
            firstName : $scope.firstName,
            lastName : $scope.lastName,
            userName : $scope.userName,
            roleDtos : $scope.roles.selectedOptions
        };

		var res;

		if ($scope.id == "") {
		    // create user
			res = $http.post(
			        $scope.userService,
			        JSON.stringify(addUser),
			        {headers: { 'Content-Type': 'application/json'}}
            );
		} else {
		    // update user
		    addUser.userId = $scope.id;
			res = $http.put(
			        $scope.userService,
			        JSON.stringify(addUser),
			        {headers: { 'Content-Type': 'application/json'}}
            );
		}

		// on request success
		res.then(
		    function(data, status, headers, config) {
                $scope.message = data;
                $scope.getUsers();
                $scope.showDivs(true);
		}, // on request error
		    function(data, status, headers, config) {
                alert( "failure message: " + JSON.stringify({data: data}));
            }
		);
	}

	/**
     * Delete a user
     */
	$scope.deleteUser = function() {
		res = $http.delete($scope.userService + "/" + $scope.id);

		// success and error calls have been deprecated
		// they are replaced with the syntax below:
		res.then(
		    function(data, status, headers, config) {
                $scope.getUsers();
                $scope.showDivs(true);
        }, // on request error
            function(data, status, headers, config) {
                    alert( "failure message: " + JSON.stringify({data: data}));
            }
		);
	}

	/**
     * Search users
     */
	$scope.searchUsers = function() {
	    var url = $scope.userService + "/" + $scope.searchType + "/" + $scope.searchText;
		$http.get(url)
		    .then(
		        function(response) {
                    $scope.users = response.data;
                    $scope.showDivs(true);
                    $scope.searchText = "";
			}, // on request error
			    function(data, status, headers, config) {
			        $scope.users = [];
			        $scope.showDivs(true);
			    }
			);
	}

    /**
     * Show user detail
     */
	$scope.showDetail = function() {
		$scope.showDivs(false);
		$scope.showPhoto = true;
		$scope.formTitle = "Update User"

		$scope.id = $scope.user.userId;
		$scope.photo = $scope.user.photo;
		$scope.firstName = $scope.user.firstName;
		$scope.lastName = $scope.user.lastName;
		$scope.userName = $scope.user.userName;
		$scope.roles.selectedOptions = $scope.user.roleDtos;
	}

});
