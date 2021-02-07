package com.fenix.C04_InterfaceEngine;

import java.util.List;

import javax.ejb.Local;

import com.fenix.C01_DataEngine.ConexionDB;
import com.fenix.C02_ModelEngine.dtoCarrito;


@Local
public interface CarritoLELocal {
	public List<dtoCarrito> ingresar(dtoCarrito objContexto);
	public List<dtoCarrito> consultar();
	public List<dtoCarrito> consultar(dtoCarrito objContexto);
	public List<dtoCarrito> consultaGenerica(String campo, String valor, int filtro, String orden, int min, int max);
	public dtoCarrito consultarId(int id);
	
	//metodos adicionales
	 public dtoCarrito consultaCedula(String _cedula);
}
