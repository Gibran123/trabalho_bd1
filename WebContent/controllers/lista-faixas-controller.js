"use strict";

(function(){
	
	angular.module("bd1").controller("FaixaController", FaixaController);
	
	FaixaController.$inject = ["$http"];
	
	function FaixaController($http){
		
		var vm  = this;
		
		vm.faixas = [];
		
		vm.showLoad = false;
		
		vm.query = " ";
		
		vm.getFaixas = function() {
			
			vm.showLoad = true;
			
			vm.faixas = [];
			
			$http({
				  method: 'GET',
				  url: 'http://localhost:8080/CatalogoCD/rest/faixas?cd='+vm.query
				})
				.then(function successCallback(response) {
				    
						vm.faixas = response.data;
						
						vm.showLoad = false;
					
				 }, function errorCallback(response) {
				    
					  	console.log("Erro");
					  
					  	vm.showLoad = false;
				 });
			
		}
		
		
		
	}
	
	
})();