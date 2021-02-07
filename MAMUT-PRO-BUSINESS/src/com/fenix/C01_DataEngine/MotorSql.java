package com.fenix.C01_DataEngine;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;
import java.util.Map.Entry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.fenix.C00_HelperEngine.Helper;


public class MotorSql implements IMotor{

	private String DATA_SOURCE = "java:/MSSQLDS";
	 
	@Override
	public Connection devolverConexion() {
		Connection rs=null;
		 try {
			 Context ic=new InitialContext();
			 DataSource ds=(DataSource)ic.lookup(DATA_SOURCE);
			 rs=ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 catch (NamingException e1) {
				e1.printStackTrace();
			}
		return rs;
	}
	

	@Override
	public void ResetKey(String clase, Connection c) {
		try {
			String QB="ALTER TABLE "+clase+" AUTO_INCREMENT = 0;";
			PreparedStatement sentencia;
			sentencia=c.prepareStatement(QB);
			sentencia.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int _GenericDelete(ConexionDB c, String name, String campo, Object valor) throws SQLException {
		String QB = "";
        QB = "DELETE FROM " + name + " WHERE " + campo + "=" + String.valueOf(valor);
        c.CrearComando(QB,false);
        
        return c.EjecutarEscalar(false);
	}

	@Override
	public int _GenericInsert(ConexionDB c, Object clase)throws SQLException {
		
		String QB = "";
		try {
			Field[] propiedades = clase.getClass().getDeclaredFields();     
	        QB = "INSERT INTO " + clase.getClass().getSimpleName() + "(";
	        for (Field item : propiedades) {
	        	item.setAccessible(true);
	        	if (!item.getName().equals("id"))
	                QB += item.getName() + ",";
	        }
	        QB = QB.substring(0, QB.length() - 1);
	        QB += ") VALUES(";
	        for (Field item : propiedades)
	            if (!item.getName().equals("id"))
	                QB += "?,";
	        QB = QB.substring(0, QB.length() - 1);
	        QB += ")";
	        c.CrearComando(QB,true);
	        int campoindex=1;
	        for (Field item : propiedades)
	        {	
	        	
	            String fecha = "";
	            Object t = item.get(clase);
	            if (t != null)
	                fecha = String.valueOf(t);
	            if (!item.getName().equals("id"))
	            {
	                if (item.getName().equals("fecha_creacion")) {
	                    c.AsignarParametro(campoindex, new Timestamp(System.currentTimeMillis()),item.getClass().getTypeName());
	                }else {
	                    if ((fecha == "01/01/0001 0:00:00") || t == null) 
	                    	c.AsignarParametro(campoindex, null,item.getClass().getTypeName());
	                    else 
	                    	c.AsignarParametro(campoindex, item.get(clase),item.getClass().getTypeName());
	                }
	                campoindex++;
	            }
	        }
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		
		
        return c.EjecutarEscalar(true);
	}

	@Override
	public int _GenericUpdate(ConexionDB c, Object clase)throws SQLException {
		String QB = "";
		try {
			Field[] propiedades = clase.getClass().getDeclaredFields();
	        QB = "UPDATE " + clase.getClass().getSimpleName() + " SET ";
	        for (Field item : propiedades)
	        {
	        	item.setAccessible(true);
	            if (!item.getName().equals("id")&&!item.getName().equals("fecha_creacion"))
	            {
	                if(item.getName().equals("fecha_modificacion"))
	                    QB += item.getName() + "='" + String.valueOf(new Timestamp(System.currentTimeMillis())) + "',";
	                else 
	                    QB += item.getName() + "='" + item.get(clase) + "',";

	            }
	        }
	        QB = QB.substring(0, QB.length() - 1);
	        
	        QB += " WHERE id='"+propiedades[0].get(clase)+"'";

	        c.CrearComando(QB,true);	        
			
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
        


        return c.EjecutarEscalar(false);
	
	}

	@Override
	public List<Object> SelectQuery(ConexionDB c, Object clase, String campo, String valor, int filtro, String orden,
			int min, int max) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		String QB = "SELECT ";
        List<Object> respuesta = new ArrayList<Object>();
        

        Field[] fields = clase.getClass().getDeclaredFields();
        for (Field field : fields)
            QB += field.getName() + ",";
        
        QB = QB.substring(0, QB.length() - 1);
        QB += " FROM " + clase.getClass().getSimpleName() + " ";

        if ((campo != null && valor != null))
            QB += " WHERE " + campo + "=" + valor;

        QB += " ORDER BY " + fields[filtro].getName();
        if (!(min == 0 && max == 0))
            QB = " OFFSET " + min + " ROWS FETCH NEXT " + max + " ROWS ONLY";

        
        c.CrearComando(QB,false);
        ResultSet rs = c.EjecutarConsulta();
        
        while (rs.next())
        {
        	Class<?> Dtype = Class.forName(clase.getClass().getName());
			Object genericObject=Dtype.newInstance();
			for (Field field : fields) {
				if(rs.getObject(field.getName())!=null)
					Helper.setField(genericObject, field.getName(), rs.getObject(field.getName()));
			}
				
			respuesta.add(genericObject);
        }
        
        
        
        rs.close();
        return respuesta;
	}

	@Override
	public void DinamicQueryEndLine(ConexionDB c, String QB, Object... tipos) throws SQLException {
		 c.CrearComando(QB,false);
         if (tipos != null)
         {
             for (int i = 0; i < tipos.length; i++)
             {
                 c.AsignarParametro(i, tipos[i],tipos[i].getClass().getTypeName());
             }
         }


         c.EjecutarComando();
		
	}

	@Override
	public ResultSet DinamicQueryOutLine(ConexionDB c, String QB, LinkedHashMap<String, Object> parametros) throws SQLException {
		c.CrearComando(QB,false);

        if (parametros.size()>0)
        {
        	
        	int contador=1;
        	
            for (Entry<String, Object> item : parametros.entrySet()) {
            	
            	c.AsignarParametro(contador, item.getValue(),item.getValue().getClass().getTypeName());
            	contador++;
            }
                
        }
        ResultSet rs = c.EjecutarConsulta();
        
        return rs;
	}

	@Override
	public String QBQuery(Object _ctx, String __Query) {
		return __Query;
	}

	@Override
	public String QBSelect(Object _ctx, String... _campos) {
		String qb = "SELECT ";
        for (String campo : _campos)
        	qb += campo + ",";
        qb = qb.substring(0, qb.length() - 1);
        qb += " FROM " + _ctx.getClass().getSimpleName() + " ";
        return qb;
	}

	@Override
	public String QBJoin(String BQ, Object _ctx, String origen, String origen_id, String destino_id) {
		BQ += "INNER JOIN " + origen + " ON " + origen_id + " = " + destino_id + " ";
        return BQ;
	}

	@Override
	public String QBWhere(String BQ, Object _ctx, String campo, String operador, String valor) {
		if (BQ.indexOf(("WHERE")) == -1)
			BQ += "WHERE " + campo + " " + operador + " " + valor + " ";
        else
            BQ += "AND " + campo + " " + operador + " " + valor + " ";
        return BQ;
	}

	@Override
	public String QBWhereOr(String BQ, Object _ctx, String campo, String operador, String valor) {
		if (BQ.indexOf("WHERE") == -1)
			BQ += "WHERE " + campo + " " + operador + " " + valor + " ";
        else
            BQ += "OR " + campo + " " + operador + " " + valor + " ";
        return BQ;
	}

	@Override
	public String QBOrderBy(String BQ, String[] _campos) {
		BQ += "ORDER BY ";
        for(String campo : _campos)
        	BQ += campo + ",";
        BQ = BQ.substring(0, BQ.length() - 1) +" ";
        return BQ;
	}

	@Override
	public String QBLimite(String BQ, int min, int max) {
		BQ += "OFFSET "+String.valueOf(min)+" ROWS FETCH NEXT "+String.valueOf(max)+" ROWS ONLY; ";
        return BQ;
	}




}
