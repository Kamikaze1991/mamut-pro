package com.fenix.C04_LogicEngine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fenix.C01_DataEngine.ConexionDB;
import com.fenix.C02_ModelEngine.dtoCarrito;
import com.fenix.C02_ModelEngine.dtoUsuario;
import com.fenix.C03_BusinessEngine.CarritoBE;



public class CarritoLE {
	
	dtoCarrito __contexto = new dtoCarrito();
    private ConexionDB cn;
    public CarritoLE()
    {
        this.cn = new ConexionDB();
    }
	
	public void AgregarContexto(dtoCarrito _contexto) {
		this.__contexto=_contexto;
		
	}
	
	public void setConnection(ConexionDB _cn) {
		this.cn = _cn;
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	
	public List<dtoCarrito> consultaGeneral(dtoCarrito objContexto) {
		 
		List<dtoCarrito> rs=new ArrayList<dtoCarrito>();
		try{
             cn.Conectar();
             CarritoBE negocio = new CarritoBE(cn, __contexto);
             rs= negocio.consultaCompletaBE(objContexto);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
             cn.Desconectar();
        }
		return rs;
	}
	
	public List<dtoCarrito> ingresar(dtoCarrito objCarrito) {
		 
		List<dtoCarrito> rs=new ArrayList<dtoCarrito>();
		try{
             cn.Conectar();
             CarritoBE negocio = new CarritoBE(cn, __contexto);
             rs= negocio.ingresarBE(objCarrito);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
             cn.Desconectar();
        }
		return rs;
	}

}
