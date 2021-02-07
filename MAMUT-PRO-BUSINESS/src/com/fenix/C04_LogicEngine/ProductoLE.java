package com.fenix.C04_LogicEngine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fenix.C01_DataEngine.ConexionDB;
import com.fenix.C02_ModelEngine.dtoProducto;
import com.fenix.C02_ModelEngine.dtoUsuario;
import com.fenix.C03_BusinessEngine.ProductoBE;



public class ProductoLE {
	
	dtoProducto __contexto = new dtoProducto();
    private ConexionDB cn;
    public ProductoLE()
    {
        this.cn = new ConexionDB();
    }
	
	public void AgregarContexto(dtoProducto _contexto) {
		this.__contexto=_contexto;
		
	}
	
	public void setConnection(ConexionDB _cn) {
		this.cn = _cn;
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	
	public List<dtoProducto> consultaGeneral(dtoProducto objContexto) {
		 
		List<dtoProducto> rs=new ArrayList<dtoProducto>();
		try{
             cn.Conectar();
             ProductoBE negocio = new ProductoBE(cn, __contexto);
             rs= negocio.consultaCompletaBE(objContexto);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
             cn.Desconectar();
        }
		return rs;
	}
	
	public List<dtoProducto> ingresar(dtoProducto objProducto) {
		 
		List<dtoProducto> rs=new ArrayList<dtoProducto>();
		try{
             cn.Conectar();
             ProductoBE negocio = new ProductoBE(cn, __contexto);
             rs= negocio.ingresarBE(objProducto);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
             cn.Desconectar();
        }
		return rs;
	}

}
