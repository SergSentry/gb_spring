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

    $scope.addProductToCart = function (productId) {
        $http({
              url: contextPath + '/api/v1/cart/add',
              method: 'POST',
              params: {
                  id: productId
              }
        }).then(function (response) {
                $http.get(contextPath + '/api/v1/cart')
                    .then(function (response) {
                        $scope.cart_products = response.data.products;
                        $scope.cart_total_price = response.data.totalPrice;
                });
                console.log("OK");
        });
    }


    $scope.clearCart = function () {
        $http({
              url: contextPath + '/api/v1/cart/clear',
              method: 'POST',
              data: ''
        }).then(function (response) {
                $scope.cart_products = null;
                $scope.cart_total_price = 0;
                console.log("OK");
        });
    }

    $scope.init();
});