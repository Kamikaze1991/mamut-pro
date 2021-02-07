package com.fenix.C00_HelperEngine;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

import javax.json.JsonObject;

import com.fenix.C01_DataEngine.ConexionDB;
import com.fenix.C02_ModelEngine.dtoKardex;
import com.google.gson.Gson;
import com.google.gson.JsonArray;


public class Helper
{
	public static boolean setField(Object object, String fieldName, Object fieldValue) {
	    Class<?> clazz = object.getClass();
	    while (clazz != null) {
	        try {
	        	Field field = clazz.getDeclaredField(fieldName);
	            field.setAccessible(true);
	        	if(fieldValue!=null)
	        	{
	        		
		            if(fieldValue.getClass().getTypeName().equals("java.math.BigDecimal")) {
		            	
		            	String dt = field.get(object).getClass().getTypeName();
		            	
		            	
	                    field.set(object, inversor_tipos(dt, fieldValue));
		            }else if(fieldValue.getClass().getTypeName().equals("java.lang.String")) {
		            	String dt = field.getType().getName();
		            	
		            	
	                    field.set(object, inversor_tipos_string(dt, fieldValue));
		            }else {
		            	field.set(object,  fieldValue);
		            }
	        		
	        	}else {
	        		field.set(object,  fieldValue);
	        	}
	        	
	            
	            
	            
	            return true;
	        } catch (NoSuchFieldException e) {
	            clazz = clazz.getSuperclass();
	        } catch (Exception e) {
	            throw new IllegalStateException(e);
	        }
	    }
	    return false;
	 }
	
	
	
    

    public static Map<String, Object> ObjectToDictionary(Object rs)
    {
    	Map<String, Object> resultado = new HashMap<String, Object>();
    	try {
    		Field[] fields = rs.getClass().getDeclaredFields();        
    		for (Field field : fields) {
    			field.setAccessible(true);
    			resultado.put(field.getName(), field.get(rs));
    		}
    	}catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
        return resultado;
    }

    public static Object inversor_tipos(String date_type, Object tipo_tip)
    {

    	
    	String valor=String.valueOf(tipo_tip);
    	
        switch (date_type)
        {


            case "java.lang.Float":
            	return Float.valueOf(valor);
            case "System.Int16":
            	return Integer.valueOf(valor);
            case "System.Single":
            	return Double.valueOf(valor);
            default:
            	return Double.valueOf(valor);
        }
    }
    
    public static Object inversor_tipos_string(String date_type, Object tipo_tip)
    {

    	
    	String valor=String.valueOf(tipo_tip);
        switch (date_type)
        {

        	case  "java.lang.Integer":
        		return Integer.valueOf(valor);
        	case  "int":
        		return Integer.valueOf(valor);
            case "float":
            	return Float.valueOf(valor);
            case "System.Int16":
            	return Integer.valueOf(valor);
            case "System.Single":
            	return Double.valueOf(valor);
            case "java.sql.Timestamp":

            	valor=valor.replace("T", " ");
            	return Timestamp.valueOf(valor);
            default:
            	return valor;
        }
    }
    
    
    


    public static List<Map<String, Object>> ListObjectToDictionary(List<Object> rs)
    {
        List<Map<String, Object>> tuplas = new ArrayList<Map<String, Object>>();
        try {
        	for(Object item:rs)
            {
            	Field[] fields = item.getClass().getDeclaredFields();
                Map<String, Object> tupla = new HashMap<String, Object>();
                for(Field field:fields)
                {
                    tupla.put(field.getName(), field.get(item));
                }
                tuplas.add(tupla);
            }
        }catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
        
        return tuplas;
    }



    public static Object JsonToObject(JsonObject jo, Object obj) {

		
    	Field[] fields = obj.getClass().getDeclaredFields();
    	for(Field field:fields)
        {
            field.setAccessible(true);
           
            if(jo.get(field.getName())!=null&&!jo.get(field.getName()).toString().equals("\"\"")&&!jo.get(field.getName()).toString().equals("null"))
            	setField(obj, field.getName(), jo.get(field.getName()).toString().replace("\"", ""));


        }

    	return obj;
    }
    
    public static List<Object> JsonToArrayObject(javax.json.JsonArray jsonArray, Object obj) {
    	Gson gson = new Gson();
    	List<Object> arrObjects=new ArrayList<Object>();
    	for (int i = 0; i < jsonArray.size(); i++) {
    	    JsonObject object = (JsonObject) jsonArray.get(i);
    	    Object origen=gson.fromJson(object.toString(),obj.getClass());
    	    arrObjects.add(origen);
    	}
    	return arrObjects;
    }

    public static List<LinkedHashMap<String, Object>> ResultToList(ResultSet rs)
    {

        List<LinkedHashMap<String, Object>> rows = new ArrayList<LinkedHashMap<String, Object>>();
        try {
        	while (rs.next()){
        		LinkedHashMap<String, Object> row = new LinkedHashMap<String, Object>();
        		
        		for (int i = 1; i <= rs.getMetaData().getColumnCount(); ++i){
        			row.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
        		}
        		rows.add(row);
        	}        
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

        return rows;
    }
    
    
    

    
  
    

}
