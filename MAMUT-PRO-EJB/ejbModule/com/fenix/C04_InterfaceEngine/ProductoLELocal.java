package com.fenix.C04_InterfaceEngine;

import java.util.List;

import javax.ejb.Local;

import com.fenix.C01_DataEngine.ConexionDB;
import com.fenix.C02_ModelEngine.dtoProducto;


@Local
public interface ProductoLELocal {
	public List<dtoProducto> ingresar(dtoProducto objContexto);
	public List<dtoProducto> consultar();
	public List<dtoProducto> consultar(dtoProducto objContexto);
	public List<dtoProducto> consultaGenerica(String campo, String valor, int filtro, String orden, int min, int max);
	public dtoProducto consultarId(int id);
	
	//metodos adicionales
	 public dtoProducto consultaCedula(String _cedula);
}
