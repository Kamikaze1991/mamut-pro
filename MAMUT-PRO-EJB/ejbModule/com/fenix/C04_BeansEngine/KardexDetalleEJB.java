package com.fenix.C04_BeansEngine;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.fenix.C02_ModelEngine.dtoKardexDetalle;
import com.fenix.C04_InterfaceEngine.KardexDetalleLELocal;
import com.fenix.C04_LogicEngine.KardexDetalleLE;

/**
 * Session Bean implementation class KardexDetalleEJB
 */
@Stateless
@LocalBean
public class KardexDetalleEJB implements KardexDetalleLELocal{
	
	KardexDetalleLE base_contexto = new KardexDetalleLE();

	@Override
	public List<dtoKardexDetalle> ingresar(dtoKardexDetalle objContexto) {
		return this.base_contexto.ingresar(objContexto);
	}


	@Override
	public List<dtoKardexDetalle> consultar() {
		// TODO Auto-generated method stub
		return this.base_contexto.consultaGeneral(null);
	}

	@Override
	public List<dtoKardexDetalle> consultaGenerica(String campo, String valor, int filtro, String orden, int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public dtoKardexDetalle consultarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public dtoKardexDetalle consultaCedula(String _cedula) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<dtoKardexDetalle> consultar(dtoKardexDetalle objContexto) {
		// TODO Auto-generated method stub
		return this.base_contexto.consultaGeneral(objContexto);
	}

    

}
