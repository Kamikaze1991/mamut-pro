package com.fenix.C02_ModelEngine;

import java.sql.Timestamp;

public class dtoKardexDetalle {
	int ka_id_detalle;
	int ka_id_cabecera_kardex;
	String ka_descripcion;
	float ka_valor_unitario;
	int ka_in_cantidad;
	float ka_in_valor;
	int ka_out_cantidad;
	float ka_out_valor;
	int ka_saldo_cantidad;
	float ka_saldo_valor;
	Timestamp ka_fecha_creacion;
	Timestamp ka_fecha_modificacion;
	
	public int getid_detalle() {
		return ka_id_detalle;
	}
	public void setid_detalle(int ka_id_detalle) {
		this.ka_id_detalle = ka_id_detalle;
	}
	public int getid_cabecera_kardex() {
		return ka_id_cabecera_kardex;
	}
	public void setid_cabecera_kardex(int ka_id_cabecera_kardex) {
		this.ka_id_cabecera_kardex = ka_id_cabecera_kardex;
	}
	public String getdescripcion() {
		return ka_descripcion;
	}
	public void setdescripcion(String ka_descripcion) {
		this.ka_descripcion = ka_descripcion;
	}
	public float getvalor_unitario() {
		return ka_valor_unitario;
	}
	public void setvalor_unitario(float ka_valor_unitario) {
		this.ka_valor_unitario = ka_valor_unitario;
	}
	public int getin_cantidad() {
		return ka_in_cantidad;
	}
	public void setin_cantidad(int ka_in_cantidad) {
		this.ka_in_cantidad = ka_in_cantidad;
	}
	public float getin_valor() {
		return ka_in_valor;
	}
	public void setin_valor(float ka_in_valor) {
		this.ka_in_valor = ka_in_valor;
	}
	public int getout_cantidad() {
		return ka_out_cantidad;
	}
	public void setout_cantidad(int ka_out_cantidad) {
		this.ka_out_cantidad = ka_out_cantidad;
	}
	public float getout_valor() {
		return ka_out_valor;
	}
	public void setout_valor(float ka_out_valor) {
		this.ka_out_valor = ka_out_valor;
	}
	public int getsaldo_cantidad() {
		return ka_saldo_cantidad;
	}
	public void setsaldo_cantidad(int ka_saldo_cantidad) {
		this.ka_saldo_cantidad = ka_saldo_cantidad;
	}
	public float getsaldo_valor() {
		return ka_saldo_valor;
	}
	public void setsaldo_valor(float ka_saldo_valor) {
		this.ka_saldo_valor = ka_saldo_valor;
	}
	public Timestamp getfecha_creacion() {
		return ka_fecha_creacion;
	}
	public void setfecha_creacion(Timestamp ka_fecha_creacion) {
		this.ka_fecha_creacion = ka_fecha_creacion;
	}
	public Timestamp getfecha_modificacion() {
		return ka_fecha_modificacion;
	}
	public void setfecha_modificacion(Timestamp ka_fecha_modificacion) {
		this.ka_fecha_modificacion = ka_fecha_modificacion;
	}
	
	
}
