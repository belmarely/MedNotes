package sample.modelos;

import sample.libs.Conexion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class RegistroCitas {
    private String identidad;
    private String nombre;
    private String apellido;
    private String fechaCita;
    private Date creacion;

    public RegistroCitas(String fechaConcatenada) {
        this.fechaCita = fechaConcatenada;

    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public static boolean Guardar(RegistroCitas cita){
        try{
            PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement(
                    "INSERT INTO `registro_medico`.citas`` (`id_expediente`" +
                            ", `dia`) VALUES (?, ?);"
            );
            sentencia = cita.seteandoSentenciaPreparada(cita,sentencia);
            boolean resultado=  sentencia.execute();
            return resultado;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    private PreparedStatement seteandoSentenciaPreparada(RegistroCitas citacion, PreparedStatement sentencia){
        try{
            sentencia.setInt(1,MisFunciones.getIdPaciente());
            sentencia.setString(2, citacion.getFechaCita());

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return sentencia;
    }
}
