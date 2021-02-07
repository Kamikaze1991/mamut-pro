package com.fenix.C03_BusinessEngine;

import com.fenix.C00_HelperEngine.Helper;
import com.fenix.C01_DataEngine.ConexionDB;

import java.sql.SQLException;
import java.util.*;

public class NegocioMaestro
{
    protected ConexionDB local_cn = null;
    protected Object local_ctx = null;
    protected String QueryBuilder = "";
    protected LinkedHashMap<String, Object> local_parameters = null; 


    public NegocioMaestro(ConexionDB __c, Object __ctx)
    {
        this.local_parameters= new LinkedHashMap<String, Object>();
        this.local_cn = __c;
        this.local_ctx = __ctx;
    }

    public void setCtx(Object ctx) {
        this.local_ctx=ctx;
        
    }

    public void setParameter(String _nombre,Object _valor) {
        this.local_parameters.put(_nombre, _valor);
    }

    public int _Guardar() throws SQLException
    {
        int respuesta = 0;
        respuesta = local_cn.InsertQuery(local_ctx);
        return respuesta;
    }
    public int _Modificar() throws SQLException
    {
        int respuesta = 0;
        respuesta = local_cn.UpdateQuery(local_ctx);
        return respuesta;
    }


    public int _Eliminar(String tabla, String campo, String valor) throws SQLException
    {
        int respuesta = 0;
        respuesta = local_cn.DeleteQuery(tabla, campo,valor);
        return respuesta;
    }


    //consulta generica y limitada, que retorna una lista de objetos especifica por campos
    public List<Object> _ConsultaGenerica(String _campo, String _valor, int _filtro, String _orden, int _min, int _max) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        List<Object> rst = new ArrayList<Object>();
        rst = local_cn.SelectQuery(local_ctx, _campo, "'"+_valor+"'", _filtro, _orden, _min, _max);
        return rst;
    }

    public Object _ConsultaId( String id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
    	Object resultado=null;
        List<Object> rst = local_cn.SelectQuery(local_ctx, "id", id, 0, "ASC",0, 0);
        if(!rst.isEmpty())
        	resultado=rst.get(0);
        return resultado;
    }



    //querybuilder
    public NegocioMaestro __GenericQuery(String query)
    {
        QueryBuilder = query;
        return this;
    }

    public NegocioMaestro __QBSelect(String...___campos)
    {
        QueryBuilder+= local_cn._QBSelect(local_ctx, ___campos);
        return this;
    }

    public NegocioMaestro __QBJoin( String __origen, String __origen_id, String __destino_id)
    {
        this.QueryBuilder = local_cn._QBJoin(this.QueryBuilder, local_ctx, __origen, __origen_id, __destino_id);
        return this;
    }

    public NegocioMaestro __QBWhere(String __campo, String __operador, String __valor)
    {
        this.QueryBuilder= local_cn._QBWhere(this.QueryBuilder, local_ctx, __campo, __operador, __valor);
        return this;
    }
    public NegocioMaestro __QBWhereOr(String __campo, String __operador, String __valor)
    {
        this.QueryBuilder = local_cn._QBWhereOr(this.QueryBuilder, local_ctx, __campo, __operador, __valor);
        return this;
    }

    public NegocioMaestro __QBLimite(int __min, int __max)
    {
        this.QueryBuilder = local_cn._QBLimit(this.QueryBuilder, __min,__max);
        return this;
    }

    public NegocioMaestro __QBorderBy(String... __campos)
    {
        this.QueryBuilder = local_cn._QBOrderBy(this.QueryBuilder, __campos);
        return this;
    }

    public List<LinkedHashMap<String, Object>> get() throws SQLException
    {
    	
    	List<LinkedHashMap<String, Object>> rsx= Helper.ResultToList(local_cn._DinamicQueryOutLine(this.QueryBuilder, this.local_parameters));
    	
        this.local_parameters.clear();
        this.QueryBuilder = "";
        return rsx;
        
    }
    
    
    public void __queryOutLine(String QB, Object... items) throws SQLException
    {
        this.local_cn._DinamicQueryEndLine(QB, items);
    }
    
    
    
    

    public void __execute() throws SQLException
    {
        this.local_cn._DinamicQueryEndLine(this.QueryBuilder);
    }

    


  


    





}