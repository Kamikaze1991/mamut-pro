app.controller("empleadoController", function empleadoController($scope,$location,$http){

  $('#mrecursoshumanos > ul').css({'display':'block'});

  $scope.roles=[];
  $scope._persona = {};
  $scope._usuario = {};
  $scope._empleado = {};
  $scope._rol = {};
  $scope.empleados=[];
  $scope.validacion=false;
  $scope.pagina_actual=0;
  
  //paginacion
  $scope.paginacion=[];
  $scope.paginacion.paginas=[];
  $scope.paginacion.pagina_actual=0;
  $scope.paginacion.next=0;
  $scope.paginacion.nextAll=0;
  $scope.paginacion.previus=0;
  $scope.paginacion.previusAll=0;
  
  
  
 


  //CARGANDO LOS ROLES LA PRIMERA VEZ
  //---------------------------------
  $http({
    method: 'GET',
    url: base_url+'/api/Rol/consultar'
  }).then(function successCallback(response) {
      for(r in response.data){
        if(r==0){
          console.log("primer")
          $scope._rol.id=String(response.data[r].id);
        }
          
        $scope.roles.push(response.data[r]);
      }
        
      console.log($scope._rol.id);
    }, function errorCallback(response) {
      console.log(response);
    });

  //finalizacion del cargado de roles

  //funcion para cuando el usuario cambie el focus del identificador
  $scope.TriggerPersona=function(event){    
    $http({
      method: 'GET',
      url: base_url+'/api/Persona/consultarCedula?cedula='+$scope._persona.identificador
    }).then(function successCallback(response) {
        if(response)
          var tmp=$scope._persona.identificador;	
          $scope._persona=response.data;
          $scope._persona.identificador=tmp;
      }, function errorCallback(response) {
        
      });
  }
  
  
  $scope.pagerUpdate=function(curr_pag,npaginas){
	  $scope.paginacion.paginas=[];
	  if (curr_pag > 0) {
          $scope.paginacion.paginas.push(curr_pag - 1)
          $scope.paginacion.previus = curr_pag - 1;
      }
	  $scope.paginacion.previusAll = 0;
      $scope.paginacion.nextAll = npaginas-1;
      $scope.paginacion.next = curr_pag +1;
      
      if ($scope.paginacion.next >= npaginas)
          $scope.paginacion.next = npaginas-1;
        for (let i = curr_pag; i < (curr_pag + 4); i++) 
          if (i < npaginas)
            $scope.paginacion.paginas.push(i)
	  
  };
  
  $scope.paginaGo=function(pagina) {
	  console.log(pagina)
	  $scope.traerPaginado(pagina, 10)
	  }
  
  $scope.traerPaginado=function(_pagina,_filas,_filtro=null){
	  $("#tbl_result").css('display', 'none');
	  $(".control-container").css('display', 'none');
	  
		    let url = "";
		    if (!_filtro)
		      url ="/api/Empleado/consultaCompleta?pagina=" + _pagina + "&filas=" + _filas
		    else
		      url = "/api/Empleado/consultaCompleta?pagina=" + _pagina + "&filas=" + _filas + "&filtro=" + _filtro

		      
		      $http({
			      method: 'GET',
			      url: base_url+url
			    }).then(function successCallback(response) {
			    	
			    	let succ=response.data;
			        if(succ){
			        	
			        	
			            let pag = succ["paginas"]
			            let curr = succ["current"]
			            $scope.paginacion.pagina_actual=curr;
			            $scope.empleados=[];
			            
			            
			            
			            for (let item in succ["tuplas"]) 
			                $scope.empleados.push(succ["tuplas"][item])
			              
			            $scope.pagerUpdate(curr,pag);
			            
			            $('#tbl_result').fadeIn();
			            $('.control-container').fadeIn();
			            console.log("nona");
			        }
			         
			      }, function errorCallback(response) {
			        
			      });
		    
		    
	  
  }
  
  $scope.traerPaginado(1,10);


  //evento cuando aceptamos los valores del formulario
  $scope.actionSubmit=function(formSave){
    
    $scope.validacion=true;
    if($scope.form.$valid){  
      var parameters = {}
      $scope._usuario.identificador=$scope._usuario.username
      
      parameters["Usuario"] = $scope._usuario;
      parameters["Persona"] = $scope._persona;
      parameters["Empleado"] = $scope._empleado;
      parameters["Rol"] = $scope._rol;
      console.log(parameters);
      $http({
        method: 'POST',
        headers: {
            'Content-type': 'application/json'
        },
        url: base_url+'/api/Empleado/procesar?tipo=Ingreso',
        data:parameters
      }).then(function successCallback(response) {  
        $scope._persona={};
        $scope._usuario={};
        $scope._rol={};
        $scope._empleado={};
        $scope.validacion=false;  
      }, function errorCallback(response) {
        console.log(response);
      });


   

    }
    
  }
})