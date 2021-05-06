angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market';

    $scope.init = function () {
        $http.get(contextPath + '/api/v1/products')
            .then(function (response) {
                $scope.products = response.data;
            });
    };

    $scope.createNewProduct = function () {
        $http.post(contextPath + '/api/v1/products', $scope.newProduct)
            .then(function successCallback(response) {
                $scope.init();
                $scope.newProduct = null;
            }, function errorCallback(response) {
                console.log(response.data);
                alert('Error: ' + response.data.messages);
            });
    };

    $scope.clickOnProduct = function (product) {
        console.log(product);
    }

    $scope.pingProduct = function (productId) {
        $http({
            url: contextPath + '/api/v1/cart/ping',
            method: 'GET',
            params: {
                id: productId,
                temp: 'empty'
            }
        }).then(function (response) {
            console.log("OK");
        });
    }

    $scope.addProductToCart = function (product) {
        $http({
              url: contextPath + '/api/v1/cart/add',
              method: 'POST',
              data: product
        }).then(function (response) {
                $http.get(contextPath + '/api/v1/cart')
                    .then(function (response) {
                        $scope.cart_products = response.data;
                });
                console.log("OK");
        });
    }


    $scope.clearCart = function (productId) {
        $http({
              url: contextPath + '/api/v1/cart/clear',
              method: 'POST',
              data: ''
        }).then(function (response) {
                $http.get(contextPath + '/api/v1/cart')
                    .then(function (response) {
                        $scope.cart_products = response.data;
                });
                console.log("OK");
        });
    }

    $scope.init();
});