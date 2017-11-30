(function() {
	var app = angular.module("categorie", []);

	app
			.directive(
					"categorie",
					function() {
						return {
							restrict : 'E',
							templateUrl : "categorie.html",
							controller : function($http) {
								var self = this;
								self.categories = [];
								self.categorie = null;
								self.ajout = true;
								
								self.list = function() {
									$http({
										method : 'GET',
										url : 'api/categories'
									}).then(function success(response) {
										self.categories = response.data;
									}, function error(response) {

									});
								};

								self.add = function() {
									self.categorieForm.$setPristine();
									self.categorie = {};
									self.ajout = true;
								};

					
								self.edit = function(id) {
									self.categorieForm.$setPristine();
									$http({
										method : 'GET',
										url : 'api/categories/'+id
									}).then(function success(response) {
										self.categorie = response.data; 
										self.categorie.dtNaissance = new Date(response.data.dtNaissance)
									}, function error(response) {

									});
								};
								
								self.save = function() {
									if (self.categorie.id == null) {
										$http({
											method : 'POST',
											url : 'api/categories/',
											data : self.categorie
										}).then(function success(response) {
											self.list();
											self.cancel();
										}, function error(response) {

										});
									} else {
										$http({
											method : 'PUT',
											url : 'api/categories/',
											data : self.categorie
										}).then(function success(response) {
											self.list();
											self.cancel();
										}, function error(response) {

										});
									}
								};
								

								self.remove = function(id) {
									$http({
										method : 'DELETE',
										url : 'api/categories/'+id
									}).then(function success(response) {
										self.list();
									}, function error(response) {

									});
									
									
								};

								self.cancel = function() {
									self.categorie = null;
								};


								self.list();
							},
							controllerAs : "categorieCtrl"
						};
					});
})();