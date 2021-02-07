package com.fenix.C02_ModelEngine;

import java.sql.Timestamp;

public class dtoUsuario {
	
	
	int us_id_usuario; 		
	String us_login; 			
	String us_password; 		
	Timestamp us_fecha_creacion; 	
	Timestamp us_fecha_modificacion;
	
	public int getid_usuario() {
		return us_id_usuario;
	}
	public void setid_usuario(int us_id_usuario) {
		this.us_id_usuario = us_id_usuario;
	}
	public String getlogin() {
		return us_login;
	}
	public void setlogin(String us_login) {
		this.us_login = us_login;
	}
	public String getpassword() {
		return us_password;
	}
	public void setpassword(String us_password) {
		this.us_password = us_password;
	}
	public Timestamp getfecha_creacion() {
		return us_fecha_creacion;
	}
	public void setfecha_creacion(Timestamp us_fecha_creacion) {
		this.us_fecha_creacion = us_fecha_creacion;
	}
	public Timestamp getfecha_modificacion() {
		return us_fecha_modificacion;
	}
	public void setfecha_modificacion(Timestamp us_fecha_modificacion) {
		this.us_fecha_modificacion = us_fecha_modificacion;
	}
}
