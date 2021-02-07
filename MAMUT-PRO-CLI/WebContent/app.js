var app=angular.module(["app"],["ngRoute"]);
var base_url="/MAMUT-PRO-REST";

//controlador principal
app.controller("appController", function appController($scope,$http){

    var menus=[]
    var sw=false;
    var errore=false;

    $http({
      method: 'GET',
      url: base_url+'/api/Menuprincipal/consultar'
    }).then(function successCallback(response) {
        for(r in response.data)
          menus.push(response.data[r]);
      }, function errorCallback(response) {
        console.log(response);
        errore=true;
      });


    $scope.menuNivel = function(id){
      
        var menus_tmp=[]
        for(r in menus)
            if(menus[r].nivel==id)
                menus_tmp.push(menus[r]);
        return menus_tmp
    };

    $scope.menuPadre = function(id){
        var menus_tmp=[]
        for(r in menus)
            if(menus[r].id_menuprincipal==id)
                menus_tmp.push(menus[r]);
        return menus_tmp
    };
    
    $scope.initialJS = function(indice){
      
      console.log($scope.basemenu)
		    if (!sw&&indice==1) {
            $('#' + this.customTitle).children().addClass('active');
      
            var menu_ul = $('.menu > li > ul'),
              menu_a = $('.menu > li > a'),
              menu_aa = $('.menu > li > ul > li > a'),
              menu_ul_ul = $('.menu > li > ul > li > ul');
            $('.active').next().stop(true, true).slideDown(0);
            menu_a.click(function (e) {
              e.preventDefault();
              if (!$(this).hasClass('active')) {
                menu_a.removeClass('active');
                menu_aa.removeClass('active');
                menu_aa.next().stop(true, true).slideUp('normal');
                menu_ul.filter(':visible').slideUp('normal');
                $(this).addClass('active').next().stop(true, true).slideDown('normal');
              } else {
                $(this).removeClass('active');
                $(this).next().stop(true, true).slideUp('normal');
              }
            });
            menu_aa.click(function (e) {
              e.preventDefault();
              if (!$(this).hasClass('active')) {
                menu_aa.removeClass('active');
                menu_ul_ul.filter(':visible').slideUp('normal');
                $(this).addClass('active').next().stop(true, true).slideDown('normal');
              } else {
                $(this).removeClass('active');
                $(this).next().stop(true, true).slideUp('normal');
              }
            });
            sw = true;
          }
    }

    
})




//rutas
app.config(function($routeProvider){
	$routeProvider.when("/", {
		templateUrl : "pages/index-view.html"
	})
	.when('/empleado-admin', {
      templateUrl : "pages/empleado/empleado-view.html",
      controller : "empleadoController"
    })
 	.otherwise({ redirectTo : "/"})
})






