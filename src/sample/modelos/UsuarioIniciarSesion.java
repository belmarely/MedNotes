package sample.modelos;

import sample.libs.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class UsuarioIniciarSesion {

    private String nombre_usuario;
    private String clave;
    private Date creacion;

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }


    public static boolean comprobandoUsario(String nombre_usuario, String palabra_clave){
        boolean comprobar = false;
        try{
            PreparedStatement sentencia1 = Conexion.abrirConexion().prepareStatement("SELECT * FROM usuarios WHERE nombre_usuario = ? AND  palabra_clave = ? ");
            sentencia1.setString(1, nombre_usuario);
            sentencia1.setString(2, palabra_clave);
            ResultSet resultado=  sentencia1.executeQuery();
            while (resultado.next()) {
                comprobar= true;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return comprobar;

    }

    public UsuarioIniciarSesion(String nombre_usuario, String clave) {
        this.nombre_usuario = nombre_usuario;
        this.clave = clave;
    }
    private static UsuarioIniciarSesion crearInstancia(ResultSet resultado) {
        UsuarioIniciarSesion usuario  = null;
        try {
            usuario = new UsuarioIniciarSesion(resultado.getString("nombre_usuario"),
                    resultado.getString("palabra_clave"));
            usuario.creacion = resultado.getDate("creacion");
        } catch (SQLException e) {
            System.err.println("Algo salio mal " + e.getMessage());
        }
        return usuario;
    }

}
