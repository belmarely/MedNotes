package sample.modelos;

import javafx.scene.control.Alert;
import sample.libs.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.Date;

public class Usuario {

    private String nombre;
    private String apellido;
    private String correo_electronico;
    private String nombre_usuario;
    private String clave;
    private Date creacion;

    public static boolean Guardar(Usuario crearUsuario){

        try{
            PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement(
                    "INSERT INTO `registro_medico`.`usuarios` (`nombre`, `apellido`, `correo`,`nombre_usuario`, `palabra_clave`) \n" +
                            "VALUES (?, ?, ?, ?,?);"
            );

            sentencia = crearUsuario.seteandoSentenciaPreparada(crearUsuario,sentencia);

            boolean resultado=  sentencia.execute();
            return resultado;

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return false;
    }



    public static boolean Actualizar(Usuario actualizar){

        try{
            PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement(
                    "UPDATE `registro_medico`.`usuarios` Set `nombre`= ?, `apellido`= ?, `correo_electronico`= ?, nombre_usuario = ?, `palabra_clave` = ?\n" +
                            "WHERE (`id_usuario` = ?);"
            );

            sentencia = actualizar.seteandoSentenciaPreparada(actualizar,sentencia);
            sentencia.setInt(7,MisFunciones.getIdUsuario());


            boolean resultado=  sentencia.execute();
            return resultado;


        }catch (SQLException e){
            System.out.println(e.getMessage());

        }

        return false;


    }



    private PreparedStatement seteandoSentenciaPreparada(Usuario crearUsuario, PreparedStatement sentencia){

        try{
            sentencia.setString(1, getNombre());
            sentencia.setString(2, getApellido());
            sentencia.setString(3, getCorreo_electronico());
            sentencia.setString(4,getNombre_usuario());
            sentencia.setString(5,getClave());


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return sentencia;
    }

    public Usuario BuscarRegistro(){

        ResultSet resultado = null;

        try{
            PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement(
                    "SELECT * FROM usuarios WHERE nombre_usuario= ? ;"
            );
            sentencia.setString(1, getNombre_usuario());
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                return Usuario.crearInstancia(resultado);
            }

        }catch (SQLException e){
            System.err.println("hola  : " + e.getMessage());
        }

        return null;

    }



    private static Usuario crearInstancia(ResultSet resultado) {

       Usuario usuario  = null;

        try {
            usuario = new Usuario(resultado.getString("nombre"),
                    resultado.getString("apellido"),
                    resultado.getString("correo_electronico"),
                    resultado.getString("palabra_clave"));
            usuario.nombre_usuario = resultado.getString("nombre_usuario");
            usuario.creacion = resultado.getDate("creacion");

        } catch (SQLException e) {
            System.err.println("Algo salio mal " + e.getMessage());
        }

        return usuario;
    }



    public Usuario(String nombre, String apellido, String correo_electronico, String clave) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.correo_electronico = correo_electronico;
        this.clave = clave;

    }

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico)  {
        if(!correo_electronico.matches("^([a-z0-9._%-]+@[a-z0-9]+\\.[a-z]{2,3})")){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Formato de correo erroneo");
            alert.showAndWait();
        }

        this.correo_electronico = correo_electronico;
    }
    public String getNombre_usuario() {

        if (this.nombre_usuario == null) {

            this.nombre_usuario = this.generarNombreUsuario(0);


        }


        return nombre_usuario;
    }



    public void setNombre_usuario(String nombre_usuario)
    {
        this.nombre_usuario = nombre_usuario;
    }


    public String getClave() {
        return clave;
    }


    public void setClave(String clave) {
        this.clave = clave;
    }


    public String generarNombreUsuario(int contador) {

        String tempNombreUsuario = this.getNombre().toLowerCase()+ "." + this.getApellido().toLowerCase();

        if (contador > 0) {
            tempNombreUsuario += "." + contador;
        }

        try {
            PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement("SELECT nombre_usuario FROM usuarios WHERE " +
                    " nombre_usuario = ?");
            sentencia.setString(1, tempNombreUsuario);
            ResultSet resultado = sentencia.executeQuery();
            boolean encontrado = false;
            while (resultado.next()) {
                encontrado = true;
            }

            if (encontrado) {
                generarNombreUsuario(contador + 1);
            }

        } catch (SQLException e) {
            System.err.println("Error al generar nombre de usuario " + e.getMessage());
        }

        return tempNombreUsuario;
    }
}
