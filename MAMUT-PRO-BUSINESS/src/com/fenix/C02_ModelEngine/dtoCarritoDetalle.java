package com.fenix.C02_ModelEngine;

import java.sql.Timestamp;

public class dtoCarritoDetalle {
	int cd_id_carrito_detalle;
	int cd_id_carrito_cabecera;
	int cd_id_producto;
	int cd_cantidad;
	float cd_precio_unitario;
	int cd_total;
	Timestamp cd_fecha_creacion;
	Timestamp cd_fecha_modificacion;
	
	public int getid_carrito_detalle() {
		return cd_id_carrito_detalle;
	}
	public void setid_carrito_detalle(int cd_id_carrito_detalle) {
		this.cd_id_carrito_detalle = cd_id_carrito_detalle;
	}
	public int getid_carrito_cabecera() {
		return cd_id_carrito_cabecera;
	}
	public void setid_carrito_cabecera(int cd_id_carrito_cabecera) {
		this.cd_id_carrito_cabecera = cd_id_carrito_cabecera;
	}
	public int getid_producto() {
		return cd_id_producto;
	}
	public void setid_producto(int cd_id_producto) {
		this.cd_id_producto = cd_id_producto;
	}
	public int getcantidad() {
		return cd_cantidad;
	}
	public void setcantidad(int cd_cantidad) {
		this.cd_cantidad = cd_cantidad;
	}
	public float getprecio_unitario() {
		return cd_precio_unitario;
	}
	public void setprecio_unitario(float cd_precio_unitario) {
		this.cd_precio_unitario = cd_precio_unitario;
	}
	public int gettotal() {
		return cd_total;
	}
	public void settotal(int cd_total) {
		this.cd_total = cd_total;
	}
	public Timestamp getfecha_creacion() {
		return cd_fecha_creacion;
	}
	public void setfecha_creacion(Timestamp cd_fecha_creacion) {
		this.cd_fecha_creacion = cd_fecha_creacion;
	}
	public Timestamp getfecha_modificacion() {
		return cd_fecha_modificacion;
	}
	public void setfecha_modificacion(Timestamp cd_fecha_modificacion) {
		this.cd_fecha_modificacion = cd_fecha_modificacion;
	}
	
	
}
