package com.fenix.C04_BeansEngine;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.fenix.C02_ModelEngine.dtoProducto;
import com.fenix.C04_InterfaceEngine.ProductoLELocal;
import com.fenix.C04_LogicEngine.ProductoLE;

/**
 * Session Bean implementation class ProductoEJB
 */
@Stateless
@LocalBean
public class ProductoEJB implements ProductoLELocal{
	
	ProductoLE base_contexto = new ProductoLE();

	@Override
	public List<dtoProducto> ingresar(dtoProducto objContexto) {
		return this.base_contexto.ingresar(objContexto);
	}


	@Override
	public List<dtoProducto> consultar() {
		// TODO Auto-generated method stub
		return this.base_contexto.consultaGeneral(null);
	}

	@Override
	public List<dtoProducto> consultaGenerica(String campo, String valor, int filtro, String orden, int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public dtoProducto consultarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public dtoProducto consultaCedula(String _cedula) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<dtoProducto> consultar(dtoProducto objContexto) {
		// TODO Auto-generated method stub
		return this.base_contexto.consultaGeneral(objContexto);
	}

    

}
