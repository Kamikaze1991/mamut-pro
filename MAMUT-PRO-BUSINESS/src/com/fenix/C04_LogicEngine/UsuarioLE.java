package com.fenix.C04_LogicEngine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fenix.C01_DataEngine.ConexionDB;
import com.fenix.C02_ModelEngine.dtoUsuario;
import com.fenix.C03_BusinessEngine.UsuarioBE;



public class UsuarioLE {
	
	dtoUsuario __contexto = new dtoUsuario();
    private ConexionDB cn;
    public UsuarioLE()
    {
        this.cn = new ConexionDB();
    }
	
	public void AgregarContexto(dtoUsuario _contexto) {
		this.__contexto=_contexto;
		
	}
	
	public void setConnection(ConexionDB _cn) {
		this.cn = _cn;
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	
	public List<dtoUsuario> consultaGeneral(dtoUsuario objContexto) {
		 
		List<dtoUsuario> rs=new ArrayList<dtoUsuario>();
		try{
             cn.Conectar();
             UsuarioBE negocio = new UsuarioBE(cn, __contexto);
             rs= negocio.consultaCompletaBE(objContexto);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
             cn.Desconectar();
        }
		return rs;
	}
	
	public List<dtoUsuario> ingresar(dtoUsuario objUsuario) {
		 
		List<dtoUsuario> rs=new ArrayList<dtoUsuario>();
		try{
             cn.Conectar();
             UsuarioBE negocio = new UsuarioBE(cn, __contexto);
             rs= negocio.ingresarBE(objUsuario);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
             cn.Desconectar();
        }
		return rs;
	}

}
