package progtv;

import local.*;
import java.io.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**

 * @author noname

 */
public class UserBean  implements Serializable {
    
    private static final long serialVersionUID = 0;

    private String user = "";
    private String pass = "";
    private String nombre = "";
    private java.util.Date lastlogin = null;

    private DbProgtv dbp = new DbProgtv();

    private boolean valid = false;

    private String mensaje = "";

    // Verifcar que no se instancie en ningín caso desde una página
    public UserBean() {
        throw new RuntimeException("Acceso no permitido.");
    }

    //
    public UserBean(String user) {
        this.user = user;
    }

    //
    public String toString() {
        return user + " - " + nombre;
    }

    //
    public String getUser() {
        return user;
    }

    //
    public String getPass() {
        return "**********";
    }

    //
    public void setPass(String pass) {
        if (pass != null) {
            if (!pass.equals("**********")) {
                this.pass = pass;
            }
        }
    }

    //
    public String getNombre() {
        return nombre;
    }

    //
    protected void setNombre(String nombre) {
        if (nombre != null) {
            this.nombre = nombre;
        }
    }
    //
    public java.util.Date getLastLogin() {
        return lastlogin;
    }

    //
    public String getLastLoginLiteral() {
        try {
            if (lastlogin == null) {
                return "";
            }
            SimpleDateFormat formato =
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return formato.format(lastlogin);
        }
        catch (Exception ex) { // atención al formato !
            return "?";
        }
    }

    //
    public boolean isValid() {
        return valid;
    }

    //
    protected boolean login(String pass) {
        String sql;
        valid = false;
        mensaje = "";
        try {
            if (!dbp.conecta()) {
                mensaje = "Error conexion BD";
            }
            else if (!leer()) {
                if (mensaje == "")
                    mensaje = "Usuario " + user + " inválido";
            }
            else if (this.pass.compareTo(pass) != 0) {
                mensaje = "Usuario " + user + " inválido";
            }
            else {
                valid = true;
            }
            // login OK, actualizar fecha último acceso.
            if (valid) {
                sql =
                    "UPDATE USERS "
                        + "SET LASTLOGIN="
                        + dbp.dbc.sqlGetDate()
                        + " WHERE IDUSER="
                        + dbp.dbc.litsql(user)
                        + dbp.dbc.endsql();
                ApW.trace(sql);
                Statement stm = dbp.getConn().createStatement();
                stm.execute(sql);
            }
            if (dbp.dbc != null) {
                dbp.dbc.commit();
                dbp.dbc.close();
            }
        }
        catch (Exception ex) {
            ApW.error("login", ex);
            mensaje = "Error login";
        }
        return valid;
    }

    //
    public boolean leer() {
        boolean rc = false;
        String sql;
        try {
            sql =
                "SELECT NOMBRE"
                    + ",PASSWORD"
                    + ",LASTLOGIN"
                    + " FROM USERS "
                    + " WHERE IDUSER="
                    + dbp.dbc.litsql(user)
                    + dbp.dbc.endsql();
            ApW.trace(sql);
            Statement stm = dbp.getConn().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                setNombre(rs.getString(1));
                setPass(rs.getString(2));
                lastlogin = (java.util.Date) rs.getObject(3);
                rc = true;
            }
            else {
                mensaje = "Usuario " + user + " no encontrado.";
            }
            rs.close();
        }
        catch (Exception ex) {
            ApW.error("login", ex);
            mensaje = "Error Base de Datos";
        }
        return rc;
    }

    //
    public void logoff() {
        this.user = "";
        valid = false;
    }

    //
    public String getMensaje() {
        return mensaje;
    }
}
