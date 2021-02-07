package com.fenix.C02_ModelEngine;

import java.sql.Timestamp;

public class dtoKardex {
	int kc_id_cabecera;
	int kc_id_producto;
	String kc_localizacion;
	String kc_proveedores;
	int kc_min;
	int kc_max;
	Timestamp kc_fecha_creacion;
	Timestamp kc_fecha_modificacion;
	
	public int getid_cabecera() {
		return kc_id_cabecera;
	}
	public void setid_cabecera(int kc_id_cabecera) {
		this.kc_id_cabecera = kc_id_cabecera;
	}
	public int getid_producto() {
		return kc_id_producto;
	}
	public void setid_producto(int kc_id_producto) {
		this.kc_id_producto = kc_id_producto;
	}
	public String getlocalizacion() {
		return kc_localizacion;
	}
	public void setlocalizacion(String kc_localizacion) {
		this.kc_localizacion = kc_localizacion;
	}
	public String getproveedores() {
		return kc_proveedores;
	}
	public void setproveedores(String kc_proveedores) {
		this.kc_proveedores = kc_proveedores;
	}
	public int getmin() {
		return kc_min;
	}
	public void setmin(int kc_min) {
		this.kc_min = kc_min;
	}
	public int getmax() {
		return kc_max;
	}
	public void setmax(int kc_max) {
		this.kc_max = kc_max;
	}
	public Timestamp getfecha_creacion() {
		return kc_fecha_creacion;
	}
	public void setfecha_creacion(Timestamp kc_fecha_creacion) {
		this.kc_fecha_creacion = kc_fecha_creacion;
	}
	public Timestamp getfecha_modificacion() {
		return kc_fecha_modificacion;
	}
	public void setfecha_modificacion(Timestamp kc_fecha_modificacion) {
		this.kc_fecha_modificacion = kc_fecha_modificacion;
	}
}
