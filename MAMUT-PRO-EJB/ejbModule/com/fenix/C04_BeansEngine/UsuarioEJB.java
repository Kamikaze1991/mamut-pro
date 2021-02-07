package com.fenix.C04_BeansEngine;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.fenix.C02_ModelEngine.dtoUsuario;
import com.fenix.C04_InterfaceEngine.UsuarioLELocal;
import com.fenix.C04_LogicEngine.UsuarioLE;

/**
 * Session Bean implementation class UsuarioEJB
 */
@Stateless
@LocalBean
public class UsuarioEJB implements UsuarioLELocal{
	
	UsuarioLE base_contexto = new UsuarioLE();

	@Override
	public List<dtoUsuario> ingresar(dtoUsuario objContexto) {
		return this.base_contexto.ingresar(objContexto);
	}


	@Override
	public List<dtoUsuario> consultar() {
		// TODO Auto-generated method stub
		return this.base_contexto.consultaGeneral(null);
	}

	@Override
	public List<dtoUsuario> consultaGenerica(String campo, String valor, int filtro, String orden, int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public dtoUsuario consultarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public dtoUsuario consultaCedula(String _cedula) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<dtoUsuario> consultar(dtoUsuario objContexto) {
		// TODO Auto-generated method stub
		return this.base_contexto.consultaGeneral(objContexto);
	}

    

}
