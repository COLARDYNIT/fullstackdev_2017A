(function() {
    'use strict';

    angular
        .module('fullstackdev2017AApp')
        .controller('CategoryDetailController', CategoryDetailController);

    CategoryDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Category', 'Product'];

    function CategoryDetailController($scope, $rootScope, $stateParams, previousState, entity, Category, Product) {
        var vm = this;

        vm.category = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('fullstackdev2017AApp:categoryUpdate', function(event, result) {
            vm.category = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
