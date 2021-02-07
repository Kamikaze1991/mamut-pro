package com.fenix.C03_BusinessEngine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fenix.C01_DataEngine.ConexionDB;
import com.fenix.C02_ModelEngine.*;

public class UsuarioBE extends NegocioMaestro {

	public UsuarioBE(ConexionDB __c, Object __ctx) {
		super(__c, __ctx);
		// TODO Auto-generated constructor stub
	}
	
	public List<dtoUsuario> consultaCompletaBE(dtoUsuario objContexto) throws SQLException
    {
        List<dtoUsuario> respuesta=new ArrayList<dtoUsuario>(); 

        UsuarioBE gestorUsuarios = new UsuarioBE(this.local_cn,new dtoUsuario());

        gestorUsuarios.__GenericQuery("sps_usuario ?,?,?");
        if(objContexto==null) {
        	gestorUsuarios.setParameter("us_id_usuario", 0);
            gestorUsuarios.setParameter("us_login", "");
            gestorUsuarios.setParameter("us_password", "");
        }else {
        	gestorUsuarios.setParameter("us_id_usuario", objContexto.getid_usuario());
            gestorUsuarios.setParameter("us_login", objContexto.getlogin() );
            gestorUsuarios.setParameter("us_password", objContexto.getpassword());
        }
        
        
        
        //List<Map<String,Object>> tuplas = gestorUsuarios.get();
        List<LinkedHashMap<String, Object>> tuplas =gestorUsuarios.get();
        if(!tuplas.isEmpty())
        	respuesta= ((List<dtoUsuario>)(List<?>)tuplas);
        return respuesta;
    }
	
	public List<dtoUsuario> ingresarBE(dtoUsuario objUsuario) throws SQLException
    {

		List<dtoUsuario> respuesta=new ArrayList<dtoUsuario>(); 

        UsuarioBE gestorUsuarios = new UsuarioBE(this.local_cn,new dtoUsuario());
        
        gestorUsuarios.__GenericQuery("spi_producto ?,?,?");
        gestorUsuarios.setParameter("us_login", objUsuario.getlogin());
        gestorUsuarios.setParameter("us_password", objUsuario.getpassword());
        
        List<LinkedHashMap<String, Object>> tuplas =gestorUsuarios.get();
        if(!tuplas.isEmpty())
        	respuesta= ((List<dtoUsuario>)(List<?>)tuplas);
        return respuesta;
    }

}
