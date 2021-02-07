package com.fenix.C02_ModelEngine;

import java.sql.Timestamp;

public class dtoProducto {
	int pr_id_producto;
	String pr_nombre;
	String pr_descripcion;
	float pr_precio_base;
	Timestamp pr_fecha_creacion;
	Timestamp pr_fecha_modificacion;
	
	public int getid_producto() {
		return pr_id_producto;
	}
	public void setid_producto(int pr_id_producto) {
		this.pr_id_producto = pr_id_producto;
	}
	public String getnombre() {
		return pr_nombre;
	}
	public void setnombre(String pr_nombre) {
		this.pr_nombre = pr_nombre;
	}
	public String getdescripcion() {
		return pr_descripcion;
	}
	public void setdescripcion(String pr_descripcion) {
		this.pr_descripcion = pr_descripcion;
	}
	public float getprecio_base() {
		return pr_precio_base;
	}
	public void setprecio_base(float pr_precio_base) {
		this.pr_precio_base = pr_precio_base;
	}
	public Timestamp getfecha_creacion() {
		return pr_fecha_creacion;
	}
	public void setfecha_creacion(Timestamp pr_fecha_creacion) {
		this.pr_fecha_creacion = pr_fecha_creacion;
	}
	public Timestamp getfecha_modificacion() {
		return pr_fecha_modificacion;
	}
	public void setfecha_modificacion(Timestamp pr_fecha_modificacion) {
		this.pr_fecha_modificacion = pr_fecha_modificacion;
	}
}
