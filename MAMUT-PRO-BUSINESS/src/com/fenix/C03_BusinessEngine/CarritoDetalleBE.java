package com.fenix.C03_BusinessEngine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fenix.C01_DataEngine.ConexionDB;
import com.fenix.C02_ModelEngine.*;

public class CarritoDetalleBE extends NegocioMaestro {

	public CarritoDetalleBE(ConexionDB __c, Object __ctx) {
		super(__c, __ctx);
		// TODO Auto-generated constructor stub
	}
	
	public List<dtoCarritoDetalle> consultaCompletaBE(dtoCarritoDetalle objContexto) throws SQLException
    {
        List<dtoCarritoDetalle> respuesta=new ArrayList<dtoCarritoDetalle>(); 

        CarritoDetalleBE gestorCarritoDetalles = new CarritoDetalleBE(this.local_cn,new dtoCarritoDetalle());
        if(objContexto==null) {
        	gestorCarritoDetalles.__GenericQuery("sps_carrito_detalle ?,?,?,?,?,?");
            gestorCarritoDetalles.setParameter("cd_id_carrito_detalle", 0);
            gestorCarritoDetalles.setParameter("cd_id_carrito_cabecera", 0);
            gestorCarritoDetalles.setParameter("cd_id_producto", 0);
            gestorCarritoDetalles.setParameter("cd_cantidad", 0);
            gestorCarritoDetalles.setParameter("cd_precio_unitario", 0.0);
            gestorCarritoDetalles.setParameter("cd_total", 0.0);	
        }else {
        	gestorCarritoDetalles.__GenericQuery("sps_carrito_detalle ?,?,?,?,?,?");
            gestorCarritoDetalles.setParameter("cd_id_carrito_detalle", objContexto.getid_carrito_detalle());
            gestorCarritoDetalles.setParameter("cd_id_carrito_cabecera", objContexto.getid_carrito_cabecera());
            gestorCarritoDetalles.setParameter("cd_id_producto", objContexto.getid_producto());
            gestorCarritoDetalles.setParameter("cd_cantidad", objContexto.getcantidad());
            gestorCarritoDetalles.setParameter("cd_precio_unitario", objContexto.getprecio_unitario());
            gestorCarritoDetalles.setParameter("cd_total", objContexto.gettotal());
        }
        //List<Map<String,Object>> tuplas = gestorCarritoDetalles.get();
        List<LinkedHashMap<String, Object>> tuplas =gestorCarritoDetalles.get();
        if(!tuplas.isEmpty())
        	respuesta= ((List<dtoCarritoDetalle>)(List<?>)tuplas);
        return respuesta;
    }
	
	public List<dtoCarritoDetalle> ingresarBE(dtoCarritoDetalle objCarritoDetalle) throws SQLException
    {

		List<dtoCarritoDetalle> respuesta=new ArrayList<dtoCarritoDetalle>(); 

        CarritoDetalleBE gestorCarritoDetalles = new CarritoDetalleBE(this.local_cn,new dtoCarritoDetalle());
        
        gestorCarritoDetalles.__GenericQuery("spi_carrito_detalle ?,?,?,?,?");
        gestorCarritoDetalles.setParameter("cd_id_carrito_cabecera", objCarritoDetalle.getid_carrito_cabecera());
        gestorCarritoDetalles.setParameter("cd_id_producto", objCarritoDetalle.getid_producto());
        gestorCarritoDetalles.setParameter("cd_cantidad", objCarritoDetalle.getcantidad());
        gestorCarritoDetalles.setParameter("cd_precio_unitario", objCarritoDetalle.getprecio_unitario());
        gestorCarritoDetalles.setParameter("cd_total", objCarritoDetalle.gettotal());
        
        //List<Map<String,Object>> tuplas = gestorCarritoDetalles.get();
        //List<LinkedHashMap<String, Object>> tuplas =gestorCarritoDetalles.get();
        List<LinkedHashMap<String, Object>> tuplas =gestorCarritoDetalles.get();
        if(!tuplas.isEmpty())
        	respuesta= ((List<dtoCarritoDetalle>)(List<?>)tuplas);
        return respuesta;
    }

}
