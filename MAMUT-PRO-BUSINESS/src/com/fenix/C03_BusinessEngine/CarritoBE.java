package com.fenix.C03_BusinessEngine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fenix.C01_DataEngine.ConexionDB;
import com.fenix.C02_ModelEngine.*;

public class CarritoBE extends NegocioMaestro {

	public CarritoBE(ConexionDB __c, Object __ctx) {
		super(__c, __ctx);
		// TODO Auto-generated constructor stub
	}
	
	public List<dtoCarrito> consultaCompletaBE(dtoCarrito objContexto) throws SQLException
    {
        List<dtoCarrito> respuesta=new ArrayList<dtoCarrito>(); 

        CarritoBE gestorCarritos = new CarritoBE(this.local_cn,new dtoCarrito());

        gestorCarritos.__GenericQuery("sps_carrito_cabecera ?,?,?,?");
        if(objContexto==null) {
        	gestorCarritos.setParameter("cc_id_carrito_cabecera", 0);
            gestorCarritos.setParameter("cc_id_usuario", 0);
            gestorCarritos.setParameter("cc_descripcion", "");
            gestorCarritos.setParameter("cc_direccion", "");	
        }else {
        	gestorCarritos.setParameter("cc_id_carrito_cabecera", objContexto.getid_carrito_cabecera());
            gestorCarritos.setParameter("cc_id_usuario", objContexto.getid_usuario());
            gestorCarritos.setParameter("cc_descripcion", objContexto.getdescripcion());
            gestorCarritos.setParameter("cc_direccion", objContexto.getdireccion());
        }
        
        
        //List<Map<String,Object>> tuplas = gestorCarritos.get();
        List<LinkedHashMap<String, Object>> tuplas =gestorCarritos.get();
        if(!tuplas.isEmpty())
        	respuesta= ((List<dtoCarrito>)(List<?>)tuplas);
        return respuesta;
    }
	
	public List<dtoCarrito> ingresarBE(dtoCarrito objCarrito) throws SQLException
    {

		List<dtoCarrito> respuesta=new ArrayList<dtoCarrito>(); 

        CarritoBE gestorCarritos = new CarritoBE(this.local_cn,new dtoCarrito());
        
        gestorCarritos.__GenericQuery("spi_producto ?,?,?");
        gestorCarritos.setParameter("cc_id_usuario", objCarrito.getid_usuario());
        gestorCarritos.setParameter("cc_descripcion", objCarrito.getdescripcion());
        gestorCarritos.setParameter("cc_direccion", objCarrito.getdireccion());
        
        //List<Map<String,Object>> tuplas = gestorCarritos.get();
        //List<LinkedHashMap<String, Object>> tuplas =gestorCarritos.get();
        List<LinkedHashMap<String, Object>> tuplas =gestorCarritos.get();
        if(!tuplas.isEmpty())
        	respuesta= ((List<dtoCarrito>)(List<?>)tuplas);
        return respuesta;
    }

}
