package com.fenix.C04_InterfaceEngine;

import java.util.List;

import javax.ejb.Local;

import com.fenix.C01_DataEngine.ConexionDB;
import com.fenix.C02_ModelEngine.dtoKardexDetalle;


@Local
public interface KardexDetalleLELocal {
	public List<dtoKardexDetalle> ingresar(dtoKardexDetalle objContexto);
	public List<dtoKardexDetalle> consultar();
	public List<dtoKardexDetalle> consultar(dtoKardexDetalle objContexto);
	public List<dtoKardexDetalle> consultaGenerica(String campo, String valor, int filtro, String orden, int min, int max);
	public dtoKardexDetalle consultarId(int id);
	
	//metodos adicionales
	 public dtoKardexDetalle consultaCedula(String _cedula);
}
