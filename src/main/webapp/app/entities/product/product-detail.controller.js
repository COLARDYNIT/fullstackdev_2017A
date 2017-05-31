(function() {
    'use strict';

    angular
        .module('fullstackdev2017AApp')
        .controller('ProductDetailController', ProductDetailController);

    ProductDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Product', 'Category', 'Invoice'];

    function ProductDetailController($scope, $rootScope, $stateParams, previousState, entity, Product, Category, Invoice) {
        var vm = this;

        vm.product = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('fullstackdev2017AApp:productUpdate', function(event, result) {
            vm.product = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
