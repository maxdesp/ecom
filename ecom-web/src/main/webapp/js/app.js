(function() {
	var app = angular.module("formapp", [ "utilisateur", "client","categorie"]);

	app.controller("SwitchController", function() {
		this.onglet = "utilisateur";

		this.setOnglet = function(val) {
			this.onglet = val;
		};

		this.isOnglet = function(val) {
			return this.onglet === val;
		}
	});

})();
