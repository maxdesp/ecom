(function() {
	var app = angular.module("utilisateur", []);

	app
			.directive(
					"utilisateur",
					function() {
						return {
							restrict : 'E',
							templateUrl : "utilisateur.html",
							controller : function($http) {
								var self = this;
								self.utilisateurs = [];
								self.utilisateur = null;
								self.ajout = true;
								self.roles = [];
								
								self.list = function() {
									$http({
										method : 'GET',
										url : 'api/utilisateurs'
									}).then(function success(response) {
//										console.log(reponse);
										self.utilisateurs = response.data;
									}, function error(response) {

									});
								};

								self.add = function() {
									self.utilisateurForm.$setPristine();
									self.utilisateur = {};
									self.ajout = true;
								};

								self.getRoles = function() {
									$http({
										method : 'GET',
										url : 'api/roles'
									}).then(function success(response) {
										self.roles = response.data;
									}, function error(response) {

									});
								};
								
								self.edit = function(id) {
									self.utilisateurForm.$setPristine();
									$http({
										method : 'GET',
										url : 'api/utilisateurs/'+id
									}).then(function success(response) {
										self.utilisateur = response.data; 
										self.utilisateur.dtNaissance = new Date(response.data.dtNaissance)
									}, function error(response) {

									});
								};
								
								self.save = function() {
									if (self.utilisateur.id == null) {
										$http({
											method : 'POST',
											url : 'api/utilisateurs/',
											data : self.utilisateur
										}).then(function success(response) {
											self.list();
											self.cancel();
										}, function error(response) {

										});
									} else {
										$http({
											method : 'PUT',
											url : 'api/utilisateurs/',
											data : self.utilisateur
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
										url : 'api/utilisateurs/'+id
									}).then(function success(response) {
										self.list();
									}, function error(response) {

									});
									
									
								};

								self.cancel = function() {
									self.utilisateur = null;
								};


								self.list();
								self.getRoles();
							},
							controllerAs : "utilisateurCtrl"
						};
					});
})();