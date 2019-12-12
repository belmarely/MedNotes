package sample.modelos;

import javafx.collections.ObservableList;
import sample.libs.Conexion;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistroCitas {
    private String identidad;
    private String nombre;
    private String apellido;
    private String dia;
    private String hora;
    private int id_citas;
    private String id_paciente;
    private Date diaFechaTipoSql;

    public RegistroCitas(String dia, String hora, String id_paciente) {
        this.id_paciente= id_paciente;
        this.dia = dia;
        this.hora = hora;
    }

    public static ObservableList<RegistroCitas> llenarTableView(ObservableList<RegistroCitas> listaCitas) {
        PreparedStatement sentencia = null;
        try {
            sentencia = Conexion.abrirConexion().prepareStatement(
                    "SELECT * FROM citas " +
                            "inner join expedientes on expedientes.id_expediente=" +
                            "citas.id_expediente;"
            );
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                listaCitas.add(RegistroCitas.crearInstancia(resultado));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return listaCitas;
    }

    public static boolean comprobarValidezDeCita(String fecha, String hora){
        PreparedStatement sentencia = null;
        try {
            sentencia = Conexion.abrirConexion().prepareStatement(
                    "SELECT count(*) FROM citas where " +
                            "dia = ? and hora = ?;");
            sentencia.setString(1,fecha);
            sentencia.setString(2,hora);
            ResultSet resultado= sentencia.executeQuery();
            int contador = 0;
            while (resultado.next()) {
                 contador= resultado.getInt("count(*)");
            }
            if (contador>0) {
                return true;
            }
        }catch (SQLException e){
            System.out.println("error:" + e.getMessage());
        }
        return false;
    }


    public static ObservableList<RegistroCitas> buscarIDYNombre(ObservableList<RegistroCitas> listaCitas, String dato) {
        PreparedStatement sentencia = null;
        try {
            sentencia = Conexion.abrirConexion().prepareStatement(
                    "SELECT * FROM citas " +
                            "inner join expedientes on expedientes.id_expediente=" +
                            "citas.id_expediente where expedientes.identidad like ? " +
                            "or expedientes.nombres like ? or citas.dia like ?;"
            );
            sentencia.setString(1, dato+ "%");
            sentencia.setString(2, dato+ "%");
            sentencia.setString(3, "%" +dato+ "%");
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                listaCitas.add(RegistroCitas.crearInstancia(resultado));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return listaCitas;
    }

    public Date getDiaFechaTipoSql() {
        return diaFechaTipoSql;
    }

    public void setDiaFechaTipoSql(Date diaFechaTipoSql) {
        this.diaFechaTipoSql = diaFechaTipoSql;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
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

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getId_citas() {
        return id_citas;
    }

    public void setId_citas(int id_citas) {
        this.id_citas = id_citas;
    }

    public String getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(String id_paciente) {
        this.id_paciente = id_paciente;
    }

    public static boolean Actualizar(RegistroCitas cita){
        try{
            PreparedStatement sentencia= Conexion.abrirConexion().prepareStatement(
                    "UPDATE `registro_medico`.`citas` " +
                            "SET `id_expediente` = ?, `dia` = ?, " +
                            "`hora` = ? WHERE (`id_cita` = ?);"
            );
            sentencia = cita.seteandoSentenciaPreparada(cita,sentencia);
            sentencia.setInt(4,MisFunciones.getId_citas());
            sentencia.execute();
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return false;
    }

    public static boolean Guardar(RegistroCitas cita){
        try{
            PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement(
                    "INSERT INTO `registro_medico`.`citas` (`id_expediente`, `dia`, `hora`)" +
                            " VALUES (?, ?, ?);"
            );
            sentencia = cita.seteandoSentenciaPreparada(cita,sentencia);
            sentencia.execute();
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    private PreparedStatement seteandoSentenciaPreparada(RegistroCitas citacion, PreparedStatement sentencia){
        try{
            sentencia.setString(1,citacion.getId_paciente());
            sentencia.setString(2, citacion.getDia());
            sentencia.setString(3, citacion.getHora());
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return sentencia;
    }

    public static RegistroCitas BuscarRegistro(int id_citas) {
        ResultSet resultado = null;
        try {
            PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement(
                    "SELECT * FROM citas " +
                            "inner join expedientes on expedientes.id_expediente=citas.id_expediente" +
                            " where id_cita= ? ;"
            );
            sentencia.setInt(1,id_citas);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                return RegistroCitas.crearInstancia(resultado);
            }
        } catch (SQLException e) {
            System.err.println("Hola  : " + e.getMessage());
        }
        return null;
    }

    private static RegistroCitas crearInstancia(ResultSet resultado) {

        RegistroCitas registroCitas = null;

        try {
            registroCitas = new RegistroCitas(
                    resultado.getString("dia"),
                    resultado.getString("hora"),
                    resultado.getString("id_expediente")
            );
            registroCitas.setDiaFechaTipoSql(resultado.getDate("dia"));
            registroCitas.setId_citas(resultado.getInt("id_cita"));
            if (resultado.getString("nombres")!= null){
                registroCitas.setNombre(resultado.getString("nombres"));
                registroCitas.setApellido(resultado.getString("apellidos"));
                registroCitas.setIdentidad(resultado.getString("identidad"));
            }

        } catch (SQLException e) {
            System.err.println("Algo salio mal " + e.getMessage());
        }

        return registroCitas;
    }
}
