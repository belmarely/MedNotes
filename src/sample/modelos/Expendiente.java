package sample.modelos;

import sample.libs.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Expendiente {
    private String nombres;
    private String apellidos;
    private String telefono;
    private String identidad;
    private String sexo;
    private String edad;
    private String lugarNacimiento;
    private String fechaNacimiento;
    private String direccion;
    private String seguridadSocial;
    private int nacionalidad;
    private String sangre;
    private String tabaquismo;
    private String alcoholismo;
    private String otraDroga;
    private String hospitalarios;
    private String alergicos;
    private String traumaticos;
    private Date creacion;

    public static boolean Guardar(Expendiente expediente) {
        try {
            PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement(
                    "INSERT INTO `registro_medico`.`expedientes` " +
                            "(`nombres`, `apellidos`, `telefono`, `identidad`, `sexo`, `edad`, " +
                            " `lugar_de_nacimiento`, `fecha_de_nacimiento`, " +
                            " `direccion`, `seguridad_social`, `nacionalidad`, `tipo_de_sangre` " +
                            ", `tabaquismo` , `alcoholismo` , `otras_drogas` , `antecedentes_hospitalarios` " +
                            ", `antecedentes_alergicos` , `antecedentes_traumaticos`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"
            );

            sentencia = expediente.seteandoSentenciaPreparada(expediente, sentencia);

            boolean resultado = sentencia.execute();
            return resultado;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public static boolean CrearUsuarioUrgente(String identidad, String nombres, String apellidos) {
        try {
            PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement(
                    "INSERT INTO `registro_medico`.`expedientes` (`nombres`, " +
                            "`apellidos`, `identidad`) VALUES (?, ?, ?);"
            );

            sentencia.setString(1, nombres);
            sentencia.setString(2, apellidos);
            sentencia.setString(3, identidad);
            sentencia.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


    public static boolean Actualizar(Expendiente actualizar) {

        try {
            PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement(
                    "UPDATE `registro_medico`.`expedientes` \n" +
                            "SET nombres=?`" +
                            ", `apellidos=?`, `telefono=?`, `identidad=?`, `sexo=?`, `edad=?`, " +
                            " `lugar_de_nacimmiento=?`, `fecha_de_nacimiento=?`, " +
                            " `direccion=?`, `seguridad_social=?`, `nacionalidad=?`, `tipo_de_sangre=?` " +
                            ", `tabaquismo=? , `alcoholismo=?` , `otras_drogas=?`" +
                            ", `antecedentes_hospitalarios=?` , `antecedentes_alergicos=? " +
                            ", `antecedentes_traumaticos=?" +
                            " WHERE (`id_expediente` = ?);"
            );

            sentencia = actualizar.seteandoSentenciaPreparada(actualizar, sentencia);
            sentencia.setInt(14, MisFunciones.getIdPaciente());


            boolean resultado = sentencia.execute();
            return resultado;


        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

        return false;


    }


    private PreparedStatement seteandoSentenciaPreparada(Expendiente setearExpediente, PreparedStatement sentencia) {

        try {
            sentencia.setString(1, getNombres());
            sentencia.setString(2, getApellidos());
            sentencia.setString(3, getTelefono());
            sentencia.setString(4, getIdentidad());
            sentencia.setString(5, getSexo());
            sentencia.setString(6, getEdad());
            sentencia.setString(7, getLugarNacimiento());
            sentencia.setString(8, getFechaNacimiento());
            sentencia.setString(9, getDireccion());
            sentencia.setString(10, getSeguridadSocial());
            sentencia.setInt(11, getNacionalidad());
            sentencia.setString(12, getSangre());
            sentencia.setString(13, getTabaquismo());
            sentencia.setString(14, getAlcoholismo());
            sentencia.setString(15, getOtraDroga());
            sentencia.setString(16, getHospitalarios());
            sentencia.setString(17, getAlergicos());
            sentencia.setString(18, getTraumaticos());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return sentencia;
    }

    public Expendiente BuscarRegistro() {
        ResultSet resultado = null;
        try {
            PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement(
                    "SELECT * FROM expedientes WHERE nombres= ? ;"
            );
            sentencia.setString(1, getNombres());
            resultado = sentencia.executeQuery();

            while (resultado.next()) {
                return Expendiente.crearInstancia(resultado);
            }
        } catch (SQLException e) {
            System.err.println("Hola  : " + e.getMessage());
        }
        return null;
    }

    public static boolean confirmarIdentidad(String identidad) {
        ResultSet resultado = null;
        try {
            PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement(
                    "SELECT * FROM expedientes WHERE identidad = ? ;"
            );
            sentencia.setString(1, identidad);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error ingrese una identidad correcta: " + e.getMessage());
        }
        return false;
    }

    public static int obtenerIdPaciente(String identidad) {
        ResultSet resultado = null;
        try {
            PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement(
                    "SELECT * FROM expedientes WHERE identidad = ? ;"
            );
            sentencia.setString(1, identidad);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                return resultado.getInt("id_expediente");
            }
        } catch (SQLException e) {
            System.err.println("Error ingrese una identidad correcta: " + e.getMessage());
        }
        return 0;
    }


    private static Expendiente crearInstancia(ResultSet resultado) {

        Expendiente expendienteInstancia = null;

        try {
            expendienteInstancia = new Expendiente(resultado.getString("nombres"),
                    resultado.getString("apellidos"),
                    resultado.getString("telefono"),
                    resultado.getString("identidad"),
                    resultado.getString("sexo"),
                    resultado.getString("edad"),
                    resultado.getString("lugar_de_nacimiento"),
                    resultado.getString("fecha_de_nacimiento"),
                    resultado.getString("direccion"),
                    resultado.getString("seguridad_social"),
                    resultado.getInt("nacionalidad"),
                    resultado.getString("tipo_sangre"),
                    resultado.getString("tabaquismo"),
                    resultado.getString("alcoholismo"),
                    resultado.getString("otras_drogas"),
                    resultado.getString("antecendetes_hospitalarios"),
                    resultado.getString("antecendetes_alergicos"),
                    resultado.getString("antecendetes_traumaticos")
            );
            expendienteInstancia.creacion = resultado.getDate("creacion");

        } catch (SQLException e) {
            System.err.println("Algo salio mal " + e.getMessage());
        }

        return expendienteInstancia;
    }

    public Expendiente(String nombres, String apellidos, String telefono, String identidad, String sexo, String edad, String lugarNacimiento, String fechaNacimiento, String direccion, String seguridadSocial, int nacionalidad, String sangre, String tabaquismo, String alcoholismo, String otraDroga, String hospitalarios, String alergicos, String traumaticos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.identidad = identidad;
        this.sexo = sexo;
        this.edad = edad;
        this.lugarNacimiento = lugarNacimiento;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.seguridadSocial = seguridadSocial;
        this.nacionalidad = nacionalidad;
        this.sangre = sangre;
        this.tabaquismo = tabaquismo;
        this.alcoholismo = alcoholismo;
        this.otraDroga = otraDroga;
        this.hospitalarios = hospitalarios;
        this.alergicos = alergicos;
        this.traumaticos = traumaticos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSeguridadSocial() {
        return seguridadSocial;
    }

    public void setSeguridadSocial(String seguridadSocial) {
        this.seguridadSocial = seguridadSocial;
    }

    public int getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(int nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getSangre() {
        return sangre;
    }

    public void setSangre(String sangre) {
        this.sangre = sangre;
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTabaquismo() {
        return tabaquismo;
    }

    public void setTabaquismo(String tabaquismo) {
        this.tabaquismo = tabaquismo;
    }

    public String getAlcoholismo() {
        return alcoholismo;
    }

    public void setAlcoholismo(String alcoholismo) {
        this.alcoholismo = alcoholismo;
    }

    public String getOtraDroga() {
        return otraDroga;
    }

    public void setOtraDroga(String otraDroga) {
        this.otraDroga = otraDroga;
    }

    public String getHospitalarios() {
        return hospitalarios;
    }

    public void setHospitalarios(String hospitalarios) {
        this.hospitalarios = hospitalarios;
    }

    public String getAlergicos() {
        return alergicos;
    }

    public void setAlergicos(String alergicos) {
        this.alergicos = alergicos;
    }

    public String getTraumaticos() {
        return traumaticos;
    }

    public void setTraumaticos(String traumaticos) {
        this.traumaticos = traumaticos;
    }
}
