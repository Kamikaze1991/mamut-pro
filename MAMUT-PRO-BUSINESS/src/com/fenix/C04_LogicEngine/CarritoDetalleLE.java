package com.fenix.C04_LogicEngine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fenix.C01_DataEngine.ConexionDB;
import com.fenix.C02_ModelEngine.dtoCarritoDetalle;
import com.fenix.C02_ModelEngine.dtoUsuario;
import com.fenix.C03_BusinessEngine.CarritoDetalleBE;



public class CarritoDetalleLE {
	
	dtoCarritoDetalle __contexto = new dtoCarritoDetalle();
    private ConexionDB cn;
    public CarritoDetalleLE()
    {
        this.cn = new ConexionDB();
    }
	
	public void AgregarContexto(dtoCarritoDetalle _contexto) {
		this.__contexto=_contexto;
		
	}
	
	public void setConnection(ConexionDB _cn) {
		this.cn = _cn;
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	
	public List<dtoCarritoDetalle> consultaGeneral(dtoCarritoDetalle objContexto) {
		 
		List<dtoCarritoDetalle> rs=new ArrayList<dtoCarritoDetalle>();
		try{
             cn.Conectar();
             CarritoDetalleBE negocio = new CarritoDetalleBE(cn, __contexto);
             rs= negocio.consultaCompletaBE(objContexto);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
             cn.Desconectar();
        }
		return rs;
	}
	
	public List<dtoCarritoDetalle> ingresar(dtoCarritoDetalle objCarritoDetalle) {
		 
		List<dtoCarritoDetalle> rs=new ArrayList<dtoCarritoDetalle>();
		try{
             cn.Conectar();
             CarritoDetalleBE negocio = new CarritoDetalleBE(cn, __contexto);
             rs= negocio.ingresarBE(objCarritoDetalle);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
             cn.Desconectar();
        }
		return rs;
	}

}
