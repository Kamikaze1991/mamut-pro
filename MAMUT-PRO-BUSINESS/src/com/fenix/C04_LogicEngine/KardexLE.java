package com.fenix.C04_LogicEngine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fenix.C01_DataEngine.ConexionDB;
import com.fenix.C02_ModelEngine.dtoKardex;
import com.fenix.C02_ModelEngine.dtoUsuario;
import com.fenix.C03_BusinessEngine.KardexBE;



public class KardexLE {
	
	dtoKardex __contexto = new dtoKardex();
    private ConexionDB cn;
    public KardexLE()
    {
        this.cn = new ConexionDB();
    }
	
	public void AgregarContexto(dtoKardex _contexto) {
		this.__contexto=_contexto;
		
	}
	
	public void setConnection(ConexionDB _cn) {
		this.cn = _cn;
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	
	public List<dtoKardex> consultaGeneral(dtoKardex objContexto) {
		 
		List<dtoKardex> rs=new ArrayList<dtoKardex>();
		try{
             cn.Conectar();
             KardexBE negocio = new KardexBE(cn, __contexto);
             rs= negocio.consultaCompletaBE(objContexto);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
             cn.Desconectar();
        }
		return rs;
	}
	
	public List<dtoKardex> ingresar(dtoKardex objKardex) {
		 
		List<dtoKardex> rs=new ArrayList<dtoKardex>();
		try{
             cn.Conectar();
             KardexBE negocio = new KardexBE(cn, __contexto);
             rs= negocio.ingresarBE(objKardex);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
             cn.Desconectar();
        }
		return rs;
	}

}
