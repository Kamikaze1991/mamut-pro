package com.fenix.C03_BusinessEngine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fenix.C01_DataEngine.ConexionDB;
import com.fenix.C02_ModelEngine.*;

public class KardexDetalleBE extends NegocioMaestro {

	public KardexDetalleBE(ConexionDB __c, Object __ctx) {
		super(__c, __ctx);
		// TODO Auto-generated constructor stub
	}
	
	public List<dtoKardexDetalle> consultaCompletaBE(dtoKardexDetalle objContexto) throws SQLException
    {
        List<dtoKardexDetalle> respuesta=new ArrayList<dtoKardexDetalle>(); 

        KardexDetalleBE gestorKardexDetalles = new KardexDetalleBE(this.local_cn,new dtoKardexDetalle());

        gestorKardexDetalles.__GenericQuery("sps_kardex_detalle ?,?,?,?,?,?,?,?,?,?");
        if(objContexto==null) {
        	gestorKardexDetalles.setParameter("ka_id_detalle", 0);
            gestorKardexDetalles.setParameter("ka_id_cabecera_kardex", 0);
            gestorKardexDetalles.setParameter("ka_descripcion", "");
            gestorKardexDetalles.setParameter("ka_valor_unitario", 0.0);
            gestorKardexDetalles.setParameter("ka_in_cantidad", 0);
            gestorKardexDetalles.setParameter("ka_in_valor", 0.0);
            gestorKardexDetalles.setParameter("ka_out_cantidad", 0);
            gestorKardexDetalles.setParameter("ka_out_valor", 0.0);
            gestorKardexDetalles.setParameter("ka_saldo_cantidad", 0);
            gestorKardexDetalles.setParameter("ka_saldo_valor", 0.0);
        }else {
        	gestorKardexDetalles.setParameter("ka_id_detalle", objContexto.getid_detalle());
            gestorKardexDetalles.setParameter("ka_id_cabecera_kardex", objContexto.getid_cabecera_kardex());
            gestorKardexDetalles.setParameter("ka_descripcion", objContexto.getdescripcion());
            gestorKardexDetalles.setParameter("ka_valor_unitario", objContexto.getvalor_unitario());
            gestorKardexDetalles.setParameter("ka_in_cantidad", objContexto.getin_cantidad());
            gestorKardexDetalles.setParameter("ka_in_valor", objContexto.getin_valor());
            gestorKardexDetalles.setParameter("ka_out_cantidad", objContexto.getout_cantidad());
            gestorKardexDetalles.setParameter("ka_out_valor", objContexto.getout_valor());
            gestorKardexDetalles.setParameter("ka_saldo_cantidad", objContexto.getsaldo_cantidad());
            gestorKardexDetalles.setParameter("ka_saldo_valor", objContexto.getsaldo_valor());
        }
        
        
        //List<Map<String,Object>> tuplas = gestorKardexDetalles.get();
        List<LinkedHashMap<String, Object>> tuplas =gestorKardexDetalles.get();
        if(!tuplas.isEmpty())
        	respuesta= ((List<dtoKardexDetalle>)(List<?>)tuplas);
        return respuesta;
    }
	
	public List<dtoKardexDetalle> ingresarBE(dtoKardexDetalle objKardex) throws SQLException
    {

		List<dtoKardexDetalle> respuesta=new ArrayList<dtoKardexDetalle>(); 

        KardexDetalleBE gestorKardexDetalles = new KardexDetalleBE(this.local_cn,new dtoKardexDetalle());
        
        gestorKardexDetalles.__GenericQuery("spi_kardex_detalle ?,?,?");
        gestorKardexDetalles.setParameter("ka_id_detalle", objKardex.getid_detalle());
        gestorKardexDetalles.setParameter("ka_id_cabecera_kardex", objKardex.getid_cabecera_kardex());
        gestorKardexDetalles.setParameter("ka_descripcion", objKardex.getdescripcion());
        gestorKardexDetalles.setParameter("ka_valor_unitario", objKardex.getvalor_unitario());
        gestorKardexDetalles.setParameter("ka_in_cantidad", objKardex.getin_cantidad());
        gestorKardexDetalles.setParameter("ka_in_valor", objKardex.getin_valor());
        gestorKardexDetalles.setParameter("ka_out_cantidad", objKardex.getout_cantidad());
        gestorKardexDetalles.setParameter("ka_out_valor", objKardex.getout_valor());
        gestorKardexDetalles.setParameter("ka_saldo_cantidad", objKardex.getsaldo_cantidad());
        gestorKardexDetalles.setParameter("ka_saldo_valor", objKardex.getsaldo_valor());
        
        //List<Map<String,Object>> tuplas = gestorKardexDetalles.get();
        //List<LinkedHashMap<String, Object>> tuplas =gestorKardexDetalles.get();
        List<LinkedHashMap<String, Object>> tuplas =gestorKardexDetalles.get();
        if(!tuplas.isEmpty())
        	respuesta= ((List<dtoKardexDetalle>)(List<?>)tuplas);
        return respuesta;
    }

}
