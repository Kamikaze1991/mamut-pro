package com.fenix.C04_BeansEngine;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.fenix.C02_ModelEngine.dtoKardex;
import com.fenix.C04_InterfaceEngine.KardexLELocal;
import com.fenix.C04_LogicEngine.KardexLE;

/**
 * Session Bean implementation class KardexEJB
 */
@Stateless
@LocalBean
public class KardexEJB implements KardexLELocal{
	
	KardexLE base_contexto = new KardexLE();

	@Override
	public List<dtoKardex> ingresar(dtoKardex objContexto) {
		return this.base_contexto.ingresar(objContexto);
	}


	@Override
	public List<dtoKardex> consultar() {
		// TODO Auto-generated method stub
		return this.base_contexto.consultaGeneral(null);
	}

	@Override
	public List<dtoKardex> consultaGenerica(String campo, String valor, int filtro, String orden, int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public dtoKardex consultarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public dtoKardex consultaCedula(String _cedula) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<dtoKardex> consultar(dtoKardex objContexto) {
		// TODO Auto-generated method stub
		return this.base_contexto.consultaGeneral(objContexto);
	}

    

}
