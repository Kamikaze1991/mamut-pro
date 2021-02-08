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
@Path("/usuario")
@ApplicationPath("/api")
public class UsuarioService extends Application {
	
	
	
	@GET
	@Path("/consultaCompleta")
	@Produces(MediaType.APPLICATION_JSON)
	public Response usuarioConsolidado(@QueryParam("pagina") String pagina,@QueryParam("filas") String filas,@QueryParam("parametro") String parametro) {
		 if(parametro==null)
			 parametro="";
		 UsuarioEJB ule = new UsuarioEJB();
		 List<dtoUsuario> productoResult=ule.consultar();
		 //Map<String,Object> rs= (Map<String, Object>) ule.consultar();
            return Response.status(201).entity(productoResult).build();
	}
	
	@POST
	@Path("/ingresar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response procesamientoPOST(JsonObject params){
		UsuarioEJB ule = new UsuarioEJB();
		
		
		dtoUsuario objUsuario = (dtoUsuario) Helper.JsonToObject(params.getJsonObject("usuario").asJsonObject(), new dtoUsuario());
		
			
		List<dtoUsuario> productoResult=ule.ingresar(objUsuario);
		return Response.status(201).entity(productoResult).build();
	
	}
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(JsonObject params){
		UsuarioEJB ule = new UsuarioEJB();
		List<dtoUsuario> productoResult=new ArrayList<dtoUsuario>();
		dtoUsuario objUsuario = (dtoUsuario) Helper.JsonToObject(params.getJsonObject("usuario").asJsonObject(), new dtoUsuario());
		if(objUsuario.getlogin()!="") {
			productoResult=ule.consultar(objUsuario);
		}
		return Response.status(201).entity(productoResult).build();
	}
	
	

	
	
	
}
