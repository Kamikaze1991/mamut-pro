package com.fenix.C04_LogicEngine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fenix.C01_DataEngine.ConexionDB;
import com.fenix.C02_ModelEngine.dtoKardexDetalle;
import com.fenix.C02_ModelEngine.dtoUsuario;
import com.fenix.C03_BusinessEngine.KardexDetalleBE;



public class KardexDetalleLE {
	
	dtoKardexDetalle __contexto = new dtoKardexDetalle();
    private ConexionDB cn;
    public KardexDetalleLE()
    {
        this.cn = new ConexionDB();
    }
	
	public void AgregarContexto(dtoKardexDetalle _contexto) {
		this.__contexto=_contexto;
		
	}
	
	public void setConnection(ConexionDB _cn) {
		this.cn = _cn;
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	
	public List<dtoKardexDetalle> consultaGeneral(dtoKardexDetalle objContexto) {
		 
		List<dtoKardexDetalle> rs=new ArrayList<dtoKardexDetalle>();
		try{
             cn.Conectar();
             KardexDetalleBE negocio = new KardexDetalleBE(cn, __contexto);
             rs= negocio.consultaCompletaBE(objContexto);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
             cn.Desconectar();
        }
		return rs;
	}
	
	public List<dtoKardexDetalle> ingresar(dtoKardexDetalle objKardexDetalle) {
		 
		List<dtoKardexDetalle> rs=new ArrayList<dtoKardexDetalle>();
		try{
             cn.Conectar();
             KardexDetalleBE negocio = new KardexDetalleBE(cn, __contexto);
             rs= negocio.ingresarBE(objKardexDetalle);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
             cn.Desconectar();
        }
		return rs;
	}

}
