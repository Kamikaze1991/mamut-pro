package com.fenix.C01_DataEngine;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface IMotor {
	public Connection devolverConexion();//return connection
	public void ResetKey(String clase,Connection c);//reset key
	
	
	
	
	int _GenericDelete(ConexionDB c, String name, String campo, Object valor)throws SQLException;
    int _GenericInsert(ConexionDB c, Object clase)throws SQLException;
    int _GenericUpdate(ConexionDB c, Object clase)throws SQLException;
    List<Object> SelectQuery(ConexionDB c, Object clase, String campo, String valor, int filtro, String orden, int min, int max)throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException; 


    void DinamicQueryEndLine(ConexionDB c, String QB, Object... tipos)throws SQLException; //query por objetos ejecucion
    ResultSet DinamicQueryOutLine(ConexionDB c, String QB, LinkedHashMap<String, Object> parametros)throws SQLException;//query por objetos, ejecucion y devolucion
    
    
    

    //--QB

    //QueryBuilders
    
    String QBQuery(Object _ctx, String __Query);
    String QBSelect(Object _ctx, String... _campos);
    String QBJoin(String BQ, Object _ctx, String origen, String origen_id, String destino_id);
    String QBWhere(String BQ, Object _ctx, String campo, String operador, String valor);
    String QBWhereOr(String BQ, Object _ctx, String campo, String operador, String valor);
    String QBOrderBy(String BQ, String[] _campos);
    String QBLimite(String BQ, int min,int max);
	
	
	
}
