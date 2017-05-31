(function() {
    'use strict';

    angular
        .module('fullstackdev2017AApp')
        .controller('InvoiceDetailController', InvoiceDetailController);

    InvoiceDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Invoice', 'Product', 'Customer'];

    function InvoiceDetailController($scope, $rootScope, $stateParams, previousState, entity, Invoice, Product, Customer) {
        var vm = this;

        vm.invoice = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('fullstackdev2017AApp:invoiceUpdate', function(event, result) {
            vm.invoice = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
