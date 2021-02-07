package com.fenix.C04_InterfaceEngine;

import java.util.List;

import javax.ejb.Local;

import com.fenix.C01_DataEngine.ConexionDB;
import com.fenix.C02_ModelEngine.dtoUsuario;


@Local
public interface UsuarioLELocal {
	public List<dtoUsuario> ingresar(dtoUsuario objContexto);
	public List<dtoUsuario> consultar();
	public List<dtoUsuario> consultar(dtoUsuario objContexto);
	public List<dtoUsuario> consultaGenerica(String campo, String valor, int filtro, String orden, int min, int max);
	public dtoUsuario consultarId(int id);
	
	//metodos adicionales
	 public dtoUsuario consultaCedula(String _cedula);
}
