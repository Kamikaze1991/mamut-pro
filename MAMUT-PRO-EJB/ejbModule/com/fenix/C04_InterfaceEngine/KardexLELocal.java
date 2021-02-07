package com.fenix.C04_InterfaceEngine;

import java.util.List;

import javax.ejb.Local;

import com.fenix.C01_DataEngine.ConexionDB;
import com.fenix.C02_ModelEngine.dtoKardex;


@Local
public interface KardexLELocal {
	public List<dtoKardex> ingresar(dtoKardex objContexto);
	public List<dtoKardex> consultar();
	public List<dtoKardex> consultar(dtoKardex objContexto);
	public List<dtoKardex> consultaGenerica(String campo, String valor, int filtro, String orden, int min, int max);
	public dtoKardex consultarId(int id);
	
	//metodos adicionales
	 public dtoKardex consultaCedula(String _cedula);
}
