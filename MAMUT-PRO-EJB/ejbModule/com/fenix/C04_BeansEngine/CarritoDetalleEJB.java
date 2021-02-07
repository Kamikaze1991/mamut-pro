package com.fenix.C04_BeansEngine;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.fenix.C02_ModelEngine.dtoCarritoDetalle;
import com.fenix.C04_InterfaceEngine.CarritoDetalleLELocal;
import com.fenix.C04_LogicEngine.CarritoDetalleLE;

/**
 * Session Bean implementation class CarritoDetalleEJB
 */
@Stateless
@LocalBean
public class CarritoDetalleEJB implements CarritoDetalleLELocal{
	
	CarritoDetalleLE base_contexto = new CarritoDetalleLE();

	@Override
	public List<dtoCarritoDetalle> ingresar(dtoCarritoDetalle objContexto) {
		return this.base_contexto.ingresar(objContexto);
	}


	@Override
	public List<dtoCarritoDetalle> consultar() {
		// TODO Auto-generated method stub
		return this.base_contexto.consultaGeneral(null);
	}

	@Override
	public List<dtoCarritoDetalle> consultaGenerica(String campo, String valor, int filtro, String orden, int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public dtoCarritoDetalle consultarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public dtoCarritoDetalle consultaCedula(String _cedula) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<dtoCarritoDetalle> consultar(dtoCarritoDetalle objContexto) {
		// TODO Auto-generated method stub
		return this.base_contexto.consultaGeneral(objContexto);
	}

    

}
