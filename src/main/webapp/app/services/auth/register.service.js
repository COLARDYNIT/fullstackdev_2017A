(function () {
    'use strict';

    angular
        .module('fullstackdev2017AApp')
        .factory('Register', Register);

    Register.$inject = ['$resource'];

    function Register ($resource) {
        return $resource('api/register', {}, {});
    }
})();
