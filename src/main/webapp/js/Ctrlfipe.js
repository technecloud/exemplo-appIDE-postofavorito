(function($app) {

	app.controller("Ctrlfipe", Ctrlfipe);
	Ctrlfipe.$inject = ['$scope', '$http', '$q'];
	function Ctrlfipe($scope, $http, $q) {

		marcas = "https://app-15-248-10040.ide.cronapp.io/api/rest/Carros/posto/todasMarcas";
		deferred = $q.defer();
		$http.get(marcas).then(function(response) {
			var raw;
			raw = response.data;
			$scope.availableOptions = raw;
			if (raw.erro) {
				$scope.availableOptions = deferred.reject('Sem dados');
				return deferred.reject('Sem dados');
			} else {
			  console.log(raw);
				$scope.availableOptions = raw;
				//	Posto.active.cep = raw.cep;
				//	Posto.active.logradouro = raw.logradouro;
				//	Posto.active.bairro = raw.bairro;
				//	Posto.active.cidade = raw.localidade;
				//	Posto.active.uf = raw.uf;
				console.log(raw);
				return deferred.resolve(raw);
			}
		});

	}

}(app));