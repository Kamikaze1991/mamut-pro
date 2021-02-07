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
import com.google.gson.Gson;
import com.fenix.C00_HelperEngine.*;


//
@Path("/kardex")
@ApplicationPath("/api")
public class KardexService extends Application {
	
	
	
	@GET
	@Path("/consultaCompleta")
	@Produces(MediaType.APPLICATION_JSON)
	public Response kardexConsolidado(@QueryParam("pagina") String pagina,@QueryParam("filas") String filas,@QueryParam("parametro") String parametro) {
		 if(parametro==null)
			 parametro="";
		 KardexEJB ule = new KardexEJB();
		 List<dtoKardex> productoResult=ule.consultar();
		 //Map<String,Object> rs= (Map<String, Object>) ule.consultar();
            return Response.status(201).entity(productoResult).build();
	}
	
	@GET
	@Path("/consultaDetalle")
	@Produces(MediaType.APPLICATION_JSON)
	public Response kardexDetalle(@QueryParam("idCabecera") int idCabecera) {
		 
		 dtoKardexDetalle objKardexDetalle=new dtoKardexDetalle();
		 objKardexDetalle.setid_cabecera_kardex(idCabecera);
		 KardexDetalleEJB ule = new KardexDetalleEJB();
		 List<dtoKardexDetalle> productoResult=ule.consultar(objKardexDetalle);
            return Response.status(201).entity(productoResult).build();
	}
	
	@POST
	@Path("/ingresar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response procesamientoPOST(JsonObject params){
		KardexEJB ule = new KardexEJB();
		dtoKardex objKardex = (dtoKardex) Helper.JsonToObject(params.getJsonObject("cabecera").asJsonObject(), new dtoKardex());
		
		Gson gson = new Gson();
		dtoKardex u = gson.fromJson(params.getJsonObject("cabecera").toString(), dtoKardex.class);
		
		
		
		
		List<Object> mDetallex=Helper.JsonToArrayObject(params.getJsonArray("detalle"), new dtoKardexDetalle());
		
		List<dtoKardexDetalle>detalles =(List<dtoKardexDetalle>)(List<?>)mDetallex;
		
		//Gson gson = new Gson();
		//NameList nameList = gson.fromJson(data, NameList.class);

		//List<Name> list = nameList.getList();
		
		
		
		String pete=detalles.get(0).getdescripcion();
		//List<dtoKardexDetalle> mDetalle=gson.fromJson(params.getJsonObject("detalle").toString(), dtoKardexDetalle.class);
		
		
		return Response.status(201).entity(objKardex).build();
	
	}
	
	

	
	
	
}
