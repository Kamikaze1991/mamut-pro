package com.fenix.C04_BeansEngine;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.fenix.C02_ModelEngine.dtoCarrito;
import com.fenix.C04_InterfaceEngine.CarritoLELocal;
import com.fenix.C04_LogicEngine.CarritoLE;

/**
 * Session Bean implementation class CarritoEJB
 */
@Stateless
@LocalBean
public class CarritoEJB implements CarritoLELocal{
	
	CarritoLE base_contexto = new CarritoLE();

	@Override
	public List<dtoCarrito> ingresar(dtoCarrito objContexto) {
		return this.base_contexto.ingresar(objContexto);
	}


	@Override
	public List<dtoCarrito> consultar() {
		// TODO Auto-generated method stub
		return this.base_contexto.consultaGeneral(null);
	}

	@Override
	public List<dtoCarrito> consultaGenerica(String campo, String valor, int filtro, String orden, int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public dtoCarrito consultarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public dtoCarrito consultaCedula(String _cedula) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<dtoCarrito> consultar(dtoCarrito objContexto) {
		// TODO Auto-generated method stub
		return this.base_contexto.consultaGeneral(objContexto);
	}

    

}
