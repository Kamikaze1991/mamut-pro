package com.fenix.C03_BusinessEngine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fenix.C01_DataEngine.ConexionDB;
import com.fenix.C02_ModelEngine.*;

public class ProductoBE extends NegocioMaestro {

	public ProductoBE(ConexionDB __c, Object __ctx) {
		super(__c, __ctx);
		// TODO Auto-generated constructor stub
	}
	
	public List<dtoProducto> consultaCompletaBE(dtoProducto objContexto) throws SQLException
    {
        List<dtoProducto> respuesta=new ArrayList<dtoProducto>(); 

        ProductoBE gestorProductos = new ProductoBE(this.local_cn,new dtoProducto());

        gestorProductos.__GenericQuery("sps_producto ?,?,?,?");
        if(objContexto==null) {
        	gestorProductos.setParameter("pr_id_producto", 0);
            gestorProductos.setParameter("pr_nombre", "");
            gestorProductos.setParameter("pr_descripcion", "");
            gestorProductos.setParameter("pr_precio_base", 0.0);
        }else {
        	gestorProductos.setParameter("pr_id_producto", objContexto.getid_producto());
            gestorProductos.setParameter("pr_nombre", objContexto.getnombre());
            gestorProductos.setParameter("pr_descripcion", objContexto.getdescripcion());
            gestorProductos.setParameter("pr_precio_base", objContexto.getprecio_base());
        }
        
        
        //List<Map<String,Object>> tuplas = gestorProductos.get();
        List<LinkedHashMap<String, Object>> tuplas =gestorProductos.get();
        if(!tuplas.isEmpty())
        	respuesta= ((List<dtoProducto>)(List<?>)tuplas);
        return respuesta;
    }
	
	public List<dtoProducto> ingresarBE(dtoProducto objProducto) throws SQLException
    {

		List<dtoProducto> respuesta=new ArrayList<dtoProducto>(); 

        ProductoBE gestorProductos = new ProductoBE(this.local_cn,new dtoProducto());
        
        gestorProductos.__GenericQuery("spi_producto ?,?,?");
        gestorProductos.setParameter("pr_nombre", objProducto.getnombre());
        gestorProductos.setParameter("pr_descripcion", objProducto.getdescripcion());
        gestorProductos.setParameter("pr_precio_base", objProducto.getprecio_base());
        
        //List<Map<String,Object>> tuplas = gestorProductos.get();
        //List<LinkedHashMap<String, Object>> tuplas =gestorProductos.get();
        List<LinkedHashMap<String, Object>> tuplas =gestorProductos.get();
        if(!tuplas.isEmpty())
        	respuesta= ((List<dtoProducto>)(List<?>)tuplas);
        return respuesta;
    }

}
