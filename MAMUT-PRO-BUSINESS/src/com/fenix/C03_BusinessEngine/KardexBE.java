package com.fenix.C03_BusinessEngine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fenix.C01_DataEngine.ConexionDB;
import com.fenix.C02_ModelEngine.*;

public class KardexBE extends NegocioMaestro {

	public KardexBE(ConexionDB __c, Object __ctx) {
		super(__c, __ctx);
		// TODO Auto-generated constructor stub
	}
	
	public List<dtoKardex> consultaCompletaBE(dtoKardex objContexto) throws SQLException
    {
        List<dtoKardex> respuesta=new ArrayList<dtoKardex>(); 

        KardexBE gestorKardexs = new KardexBE(this.local_cn,new dtoKardex());

        gestorKardexs.__GenericQuery("sps_kardex_cabecera ?,?,?,?,?,?");
        if(objContexto==null) {
        	gestorKardexs.setParameter("kc_id_cabecera", 0);
            gestorKardexs.setParameter("kc_id_producto", 0);
            gestorKardexs.setParameter("kc_localizacion", "");
            gestorKardexs.setParameter("kc_proveedores", "");
            gestorKardexs.setParameter("kc_min", 0);
            gestorKardexs.setParameter("kc_max", 0);
        }else {
        	gestorKardexs.setParameter("kc_id_cabecera", objContexto.getid_cabecera());
            gestorKardexs.setParameter("kc_id_producto", objContexto.getid_producto());
            gestorKardexs.setParameter("kc_localizacion", objContexto.getlocalizacion());
            gestorKardexs.setParameter("kc_proveedores", objContexto.getproveedores());
            gestorKardexs.setParameter("kc_min", objContexto.getmin());
            gestorKardexs.setParameter("kc_max", objContexto.getmax());
        }
        
        
        //List<Map<String,Object>> tuplas = gestorKardexs.get();
        List<LinkedHashMap<String, Object>> tuplas =gestorKardexs.get();
        if(!tuplas.isEmpty())
        	respuesta= ((List<dtoKardex>)(List<?>)tuplas);
        return respuesta;
    }
	
	public List<dtoKardex> ingresarBE(dtoKardex objKardex) throws SQLException
    {

		List<dtoKardex> respuesta=new ArrayList<dtoKardex>(); 

        KardexBE gestorKardexs = new KardexBE(this.local_cn,new dtoKardex());
        
        gestorKardexs.__GenericQuery("spi_kardex_cabecera ?,?,?,?,?");
        gestorKardexs.setParameter("kc_id_producto", objKardex.getid_producto());
        gestorKardexs.setParameter("kc_localizacion",objKardex.getlocalizacion());
        gestorKardexs.setParameter("kc_proveedores", objKardex.getproveedores());
        gestorKardexs.setParameter("kc_min", objKardex.getmin());
        gestorKardexs.setParameter("kc_max", objKardex.getmax());
        
        //List<Map<String,Object>> tuplas = gestorKardexs.get();
        //List<LinkedHashMap<String, Object>> tuplas =gestorKardexs.get();
        List<LinkedHashMap<String, Object>> tuplas =gestorKardexs.get();
        if(!tuplas.isEmpty())
        	respuesta= ((List<dtoKardex>)(List<?>)tuplas);
        return respuesta;
    }

}
