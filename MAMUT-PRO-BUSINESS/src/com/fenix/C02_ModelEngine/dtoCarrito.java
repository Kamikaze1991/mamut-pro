package com.fenix.C02_ModelEngine;

import java.sql.Timestamp;

public class dtoCarrito {
	
	int cc_id_carrito_cabecera;
	int cc_id_usuario;
	String cc_descripcion;
	String cc_direccion;
	Timestamp cc_fecha_creacion;
	Timestamp cc_fecha_modificacion;
	
	public int getid_carrito_cabecera() {
		return cc_id_carrito_cabecera;
	}
	public void setid_carrito_cabecera(int cc_id_carrito_cabecera) {
		this.cc_id_carrito_cabecera = cc_id_carrito_cabecera;
	}
	public int getid_usuario() {
		return cc_id_usuario;
	}
	public void setid_usuario(int cc_id_usuario) {
		this.cc_id_usuario = cc_id_usuario;
	}
	public String getdescripcion() {
		return cc_descripcion;
	}
	public void setdescripcion(String cc_descripcion) {
		this.cc_descripcion = cc_descripcion;
	}
	public String getdireccion() {
		return cc_direccion;
	}
	public void setdireccion(String cc_direccion) {
		this.cc_direccion = cc_direccion;
	}
	public Timestamp getfecha_creacion() {
		return cc_fecha_creacion;
	}
	public void setfecha_creacion(Timestamp cc_fecha_creacion) {
		this.cc_fecha_creacion = cc_fecha_creacion;
	}
	public Timestamp getfecha_modificacion() {
		return cc_fecha_modificacion;
	}
	public void setfecha_modificacion(Timestamp cc_fecha_modificacion) {
		this.cc_fecha_modificacion = cc_fecha_modificacion;
	}
	
	
}
