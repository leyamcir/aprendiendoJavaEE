package progtv;

import local.*;
import java.util.*;
import java.sql.*;

/**
 * Clase que almacena un Programa progtv
 *
 * @author sgs
 */

public class ProgramaBean {
	private static final long serialVersionUID = 0;
	
    private int id = 0;
    private String programa = "";
    private String horainicio = "";
    private String horafin = "";

    // Verifcar que no se instancie en ningún caso desde una página
    public ProgramaBean() {
        throw new RuntimeException("Acceso no permitido.");
    }

    //
    public ProgramaBean(int id) {
        this.id = id;
    }

    //
    public ProgramaBean(String idstr) {
        this.id = Integer.parseInt(idstr);
    }

    //
    public String toString() {
        return "[" + id + "] " + "N:" + programa + "\n";
    }

    //
    public boolean equals(ProgramaBean prog) {
        return programa.equals(prog.programa);
    }

    //
    public void setPrograma(String programa) {
        if (programa != null)
            this.programa = programa;
    }

    //
    public String getPrograma() {
        return programa;
    }

    //
    public void setHoraInicio(String hora) {
        if (hora != null)
            this.horainicio = hora;
    }

    //
    public String getHoraInicio() {
        return horainicio;
    }

    //
    public void setHoraFin(String hora) {
        if (hora != null)
            this.horafin = hora;
    }

    //
    public String getHoraFin() {
        return horafin;
    }

    //
    public int getId() {
        return id;
    }

    //
    public void setId(int id) {
        this.id = id;
        leer();
    }

    //
    public void leer() {
        String sql;
        try {
            Dbcon dbc = (new DbProgtv()).getDbc();
            Connection conn = dbc.getConn();
            Statement stm = conn.createStatement();
            sql =
                "SELECT programa,horainicio,horafin "
                    + "FROM programas "
                    + "WHERE id_prog="
                    + id
                    + dbc.endsql();
            ApW.trace(sql);
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                setPrograma(rs.getString(1));
                setHoraInicio(rs.getString(2));
                setHoraFin(rs.getString(3));
            } else {
                setPrograma("");
                setHoraInicio("");
                setHoraFin("");
            }
            dbc.commit();
        } catch (Exception ex) {
            ApW.error("ProgramaBean.leer", ex);
        }
    }

    //
    public static ProgramaBean[] leerAll(int idcadena) {
        String sql;
        Vector<ProgramaBean> m = new Vector<ProgramaBean>();
        try {
            Dbcon dbc = (new DbProgtv()).getDbc();
            Connection conn = dbc.getConn();
            Statement stm = conn.createStatement();
            sql =
                "SELECT id_prog,programa,horainicio,horafin "
                    + "FROM programas "
                    + "WHERE id_cadena="
                    + idcadena
                    + dbc.endsql();
            ApW.trace(sql);
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ProgramaBean prog = new ProgramaBean(rs.getInt(1));
                prog.setPrograma(rs.getString(2));
                prog.setHoraInicio(rs.getString(3));
                prog.setHoraFin(rs.getString(4));
                m.addElement(prog);
            }
            dbc.commit();
            dbc.close();
        } catch (Exception ex) {
            ApW.error("ProgramaBean.leerAll", ex);
        }
        return ((ProgramaBean[]) m.toArray(new ProgramaBean[0]));
    }

}
