package com.fenix.C01_DataEngine;
import java.sql.*;
import java.util.*;

public class ConexionDB {
	private Connection conn;	 
	private IMotor motor;
	private PreparedStatement comando;
	 
	public ConexionDB() {
		motor=new MotorSql();
	}
	
	public void CrearComando(String sentenciaSQL, boolean escalar) throws SQLException{
		if(escalar)
			this.comando=this.conn.prepareStatement(sentenciaSQL,Statement.RETURN_GENERATED_KEYS);
		else
			this.comando=this.conn.prepareStatement(sentenciaSQL);
    }
	
	public ResultSet EjecutarConsulta() throws SQLException
    {
		this.comando.executeQuery();
		ResultSet respuesta=null;
		return this.comando.getResultSet();
		
		/*
        int resultSetCount = 0;
        while (true) {
          if (nextResultSet) {
            resultSetCount++;
            try (ResultSet rs = this.comando.getResultSet()) {
            	respuesta=rs;
              // Do something with result set
            }
          } else {
            int updateCount = this.comando.getUpdateCount();
            if (updateCount == -1) {
              // no more results
              break;
            }
            // do something with update count
          }
          nextResultSet = this.comando.getMoreResults();
        }
        return respuesta;
        */
    }

    public int EjecutarEscalar(boolean modo) throws SQLException
    {
        int escalar = 0;
        
        this.comando.execute();
        
        	if(modo) {
            	ResultSet index=this.comando.getGeneratedKeys();
        		while(index.next()) {
        			escalar=index.getInt(1);
        		}
            }else {
            	escalar=this.comando.getUpdateCount();
            }	
        
        
        
        
        
        return escalar;
    }
    
    public void EjecutarComando() throws SQLException
    {
        this.comando.execute();
    }
	 
	public void BeginTransaction() {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
	 
	public void CommitTransaction() {
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	 
	public void RollBackTransaction() {
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public void Conectar(){ 
		if(conn==null) {
			conn = motor.devolverConexion();
		}
	}
	 
	public void Desconectar() {
		try {
			if(!conn.isClosed()) {
				conn.close();
				conn=null;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	 public void AsignarParametro(int indice, Object valor, String tipodatos) throws SQLException{
         
		 if(tipodatos.equals("java.sql.Timestamp")) {
        	 if(valor==null) {
        		 this.comando.setNull(indice, java.sql.Types.DATE);
        	 }
        	 else {
        		 this.comando.setTimestamp(indice, (Timestamp) valor);
        	 }
        		 
         }
         else {
        	 this.comando.setObject(indice, valor);
         }
		 
         
     }
	 
	 public void reset_key(String table) throws SQLException {
		motor.ResetKey(table, conn);
	 }
	
	 //metodos de la estrategia
	 public int InsertQuery(Object _clase) throws SQLException
	 {
		 return motor._GenericInsert(this, _clase);
	 }


	 public int UpdateQuery(Object _clase) throws SQLException
	 {
		 return motor._GenericUpdate(this, _clase);
	 }

    public List<Object> SelectQuery(Object clase, String campo, String valor, int filtro, String orden, int min, int max) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        return motor.SelectQuery(this, clase, campo, valor, filtro, orden, min, max);
    }

    public int DeleteQuery(String _nombre_tabla, String _campo, String _valor) throws SQLException
    {
        return motor._GenericDelete(this, _nombre_tabla, _campo, _valor);
    }



    public String _QBSelect(Object __ctx, String... __campos)
    {
        return motor.QBSelect(__ctx, __campos);
    }

    public String _QBJoin(String _BQ, Object __ctx, String _origen, String _origen_id, String _destino_id)
    {
        return motor.QBJoin(_BQ, __ctx, _origen, _origen_id, _destino_id);
    }
    public String _QBWhere(String _BQ, Object __ctx, String _campo, String _operador, String _valor)
    {
        return motor.QBWhere(_BQ, __ctx, _campo, _operador, _valor);
    }
    public String _QBWhereOr(String _BQ, Object __ctx, String _campo, String _operador, String _valor)
    {
        return motor.QBWhereOr(_BQ, __ctx, _campo, _operador, _valor);
    }
    public String _QBLimit(String _BQ, int _min, int _max)
    {
        return motor.QBLimite(_BQ, _min, _max);
    }
    public String _QBOrderBy(String _BQ, String... __campos)
    {
        return motor.QBOrderBy(_BQ, __campos);
    }

    public void _DinamicQueryEndLine(String QB, Object... tipos) throws SQLException
    {
        motor.DinamicQueryEndLine(this, QB, tipos);
    }

    public ResultSet _DinamicQueryOutLine(String QB, LinkedHashMap<String, Object> parametros) throws SQLException
    {
        return motor.DinamicQueryOutLine(this, QB, parametros);
    }

}
