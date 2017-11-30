(function() {
	var app = angular.module("client", []);

	app
			.directive(
					"client",
					function() {
						return {
							restrict : 'E',
							templateUrl : "client.html",
							controller : function($http) {
								var self = this;
								self.clients = [];
								self.client = null;
								self.ajout = true;
								self.utilisateurs = []
								self.utilisateur =

								self.list = function() {
									$http({
										method : 'GET',
										url : 'api/clients'
									}).then(function success(response) {
										self.clients = response.data;
									}, function error(response) {

									});
								};
								
								self.listUtilisateurs = function() {
									$http({
										method : 'GET',
										url : 'api/utilisateurs'
									}).then(function success(response) {
										self.utilisateurs = response.data;
									}, function error(response) {

									});
								};

								self.add = function() {
									self.clientForm.$setPristine();
									self.client = {};
									self.ajout = true;
								};

								
								self.edit = function(id) {
									self.clientForm.$setPristine();
									$http({
										method : 'GET',
										url : 'api/clients/'+id
									}).then(function success(response) {
										self.client = response.data; 
										self.client.dtNaissance = new Date(response.data.dtNaissance)
									}, function error(response) {

									});
								};
								
								self.save = function() {
									if (self.client.id == null) {
										$http({
											method : 'POST',
											url : 'api/clients/',
											data : self.client
										}).then(function success(response) {
											self.list();
											self.cancel();
										}, function error(response) {

										});
									} else {
										$http({
											method : 'PUT',
											url : 'api/clients/',
											data : self.client
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
										url : 'api/clients/'+id
									}).then(function success(response) {
										self.list();
									}, function error(response) {

									});
									
									
								};

								self.cancel = function() {
									self.client = null;
								};



								self.list();
								self.listUtilisateurs();
							},
							controllerAs : "clientCtrl"
						};
					});
})();