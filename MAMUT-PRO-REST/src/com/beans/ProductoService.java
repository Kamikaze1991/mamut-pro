package com.beans;


import java.util.*;

import javax.json.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.fenix.C02_ModelEngine.*;
import com.fenix.C04_BeansEngine.*;
import com.fenix.C00_HelperEngine.*;


//
@Path("/producto")
@ApplicationPath("/api")
public class ProductoService extends Application {
	
	
	
	@GET
	@Path("/consultaCompleta")
	@Produces(MediaType.APPLICATION_JSON)
	public Response productoConsolidado(@QueryParam("pagina") String pagina,@QueryParam("filas") String filas,@QueryParam("parametro") String parametro) {
		 if(parametro==null)
			 parametro="";
		 ProductoEJB ule = new ProductoEJB();
		 List<dtoProducto> productoResult=ule.consultar();
		 //Map<String,Object> rs= (Map<String, Object>) ule.consultar();
            return Response.status(201).entity(productoResult).build();
	}
	
	@POST
	@Path("/ingresar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response procesamientoPOST(JsonObject params){
		ProductoEJB ule = new ProductoEJB();
		
		
		dtoProducto objProducto = (dtoProducto) Helper.JsonToObject(params.getJsonObject("producto").asJsonObject(), new dtoProducto());
		
			
		List<dtoProducto> productoResult=ule.ingresar(objProducto);
		return Response.status(201).entity(productoResult).build();
	
	}
	
	

	
	
	
}
