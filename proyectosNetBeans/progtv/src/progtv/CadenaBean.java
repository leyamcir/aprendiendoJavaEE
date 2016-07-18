package progtv;

import local.*;
import java.util.*;
import java.sql.*;

/**
 * Clase que almacena una Cadena progtv
 *
 * @author sgs
 */

public class CadenaBean {
	private static final long serialVersionUID = 0;
    private int    id = 0;
    private String nombre = "";

    // Verifcar que no se instancie en ningún caso desde una página
    public CadenaBean () {
        throw new RuntimeException("Acceso no permitido.");
    }

    //
    public CadenaBean (int id) {
        this.id = id;
    }

    //
    public CadenaBean (String idstr) {
        this.id = Integer.parseInt(idstr);
    }

    //
    public String toString () {
        return "["+id+"] " + "N:"+nombre+"\n";
    }

    //
    public boolean equals (CadenaBean cad) {
        return nombre.equals(cad.nombre);
    }

    //
    public void setNombre (String nombre) {
        if (nombre != null)
            this.nombre = nombre;
    }

    //
    public String getNombre () {
        return nombre;
    }

    //
    public int getId () {
        return id;
    }

    //
    public void leer () {
        String  sql;
        try {
            Dbcon dbc = (new DbProgtv()).getDbc();
            Connection conn = dbc.getConn();
            Statement stm = conn.createStatement();
            sql = "SELECT NOMBRE "
                +   "FROM CADENAS "
                +  "WHERE ID_CADENA="+id
                + dbc.endsql();
            ApW.trace(sql);
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next())
                setNombre(rs.getString(1));
            else
                setNombre("???");
            dbc.commit();
        }
        catch (Exception ex) {
            ApW.error("CadenaBean.leer",ex);
        }
    }

    //
    public static CadenaBean[] leerAll () {
        String  sql;
        Vector<CadenaBean>  m = new Vector<CadenaBean>();
        try {
            Dbcon dbc = (new DbProgtv()).getDbc();
            Connection conn = dbc.getConn();
            Statement stm = conn.createStatement();
            sql = "SELECT ID_CADENA,NOMBRE "
                +   "FROM CADENAS "
                +  "ORDER BY NOMBRE "
                + dbc.endsql();
            ApW.trace(sql);
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                CadenaBean cad = new CadenaBean(rs.getInt(1));
                cad.setNombre(rs.getString(2));
                ApW.trace(cad.getNombre());
                m.addElement(cad);
            }
            dbc.commit();
            dbc.close();
        }
        catch (Exception ex) {
            ApW.error("CadenaBean.leerAll",ex);
        }
        return((CadenaBean[])m.toArray(new CadenaBean[0]));
    }

}

