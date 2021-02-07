package com.fenix.C04_InterfaceEngine;

import java.util.List;

import javax.ejb.Local;

import com.fenix.C01_DataEngine.ConexionDB;
import com.fenix.C02_ModelEngine.dtoCarritoDetalle;


@Local
public interface CarritoDetalleLELocal {
	public List<dtoCarritoDetalle> ingresar(dtoCarritoDetalle objContexto);
	public List<dtoCarritoDetalle> consultar();
	public List<dtoCarritoDetalle> consultar(dtoCarritoDetalle objContexto);
	public List<dtoCarritoDetalle> consultaGenerica(String campo, String valor, int filtro, String orden, int min, int max);
	public dtoCarritoDetalle consultarId(int id);
	
	//metodos adicionales
	 public dtoCarritoDetalle consultaCedula(String _cedula);
}
