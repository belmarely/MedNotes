package sample.modelos;

import javafx.collections.ObservableList;
import sample.libs.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionesOrganicasGenerales {
    private String id_examen_fisico;
    private String id_paciente;
    private String apetito ;
    private String sed;
    private String miccion ;
    private String defecacion ;
    private String sueno;
    private String txtPielFaneras;
    private String txtApariencia;
    private String txtPresion;
    private String txtFrecuenciaC;
    private String txtFrecuenciaR;
    private String txtTemperatura;
    private String txtSistemaN;
    private String txtCabeza;
    private String txtOjos;
    private String txtNariz;
    private String txtBoca;
    private String txtCuello;
    private String txtRespiratorio;
    private String txtCardioVascular;
    private String txtDigestivo;
    private String txtOsteo;
    private String txtHemat;
    private String txtMotivo;
    private String txtSintomaPrin;
    private String txtGenitou;
    private String txtInfatico;
    private String txtEndocrino;
    private String identidad;
    private String nombresPaciente;
    private String apellidosPaciente;
    private String creacionExamen;

    public String getCreacionExamen() {
        return creacionExamen;
    }

    public void setCreacionExamen(String creacionExamen) {
        this.creacionExamen = creacionExamen;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public String getNombresPaciente() {
        return nombresPaciente;
    }

    public void setNombresPaciente(String nombresPaciente) {
        this.nombresPaciente = nombresPaciente;
    }

    public String getApellidosPaciente() {
        return apellidosPaciente;
    }

    public void setApellidosPaciente(String apellidosPaciente) {
        this.apellidosPaciente = apellidosPaciente;
    }

    public static boolean Guardar(FuncionesOrganicasGenerales examenFisico){
        try{
            PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement(
                    "INSERT INTO `registro_medico`.`examenes_fisicos` (`id_paciente`" +
                            ", `sintoma_principal`, `motivo_consulta`, `apariencia_general`" +
                            ", `presion_arterial`, `frecuencia_cardiaca`," +
                            " `frecuencia_respiratoria`, `temperatura`, `apetito`," +
                            " `sed`, `sueño`, `miccion`, `defecacion`, `snc`, `cabeza`," +
                            " `ojos`, `nariz_paranasales`, `boca_faringe`, `cuello`," +
                            " `respiratorio`, `cardiovascular`, `digestivo`, `osteomuscular`," +
                            " `hematologico`, `genitoutario`, `infatico`, `endocrino`," +
                            " `piel_faneras`) VALUES (?, ?, ?, ?, ?," +
                            " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
                            " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"
            );
            sentencia = examenFisico.seteandoSentenciaPreparada(examenFisico,sentencia);
            boolean resultado=  sentencia.execute();
            return resultado;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean Actualizar(FuncionesOrganicasGenerales examenFisico){
        try{
            PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement(
                    "UPDATE `registro_medico`.`examenes_fisicos` \n" +
                            "SET `id_paciente` = ?, `sintoma_principal` = ?, \n" +
                            "`motivo_consulta` = ?, `apariencia_general` = ?, \n" +
                            "`presion_arterial` = ?, `frecuencia_cardiaca` = ?, \n" +
                            "`frecuencia_respiratoria` = ?, `temperatura` = ?, \n" +
                            "`apetito` = ?, `sed` = ?, `sueño` = ?, `miccion` = ?, \n" +
                            "`defecacion` = ?, `snc` = ?, `cabeza` = ?, `ojos` = ?,\n" +
                            " `nariz_paranasales` = ?, `boca_faringe` = ?, `cuello` = ?,\n" +
                            " `respiratorio` = ?, `cardiovascular` = ?, `digestivo` = ?, \n" +
                            "`osteomuscular` = ?, `hematologico` = ?, `genitoutario` = ?, \n" +
                            "`infatico` = ?, `endocrino` = ?, `piel_faneras` = ? \n" +
                            "WHERE (`id_examen_fisico` = ?);"
            );
            sentencia = examenFisico.seteandoSentenciaPreparada(examenFisico,sentencia);
            sentencia.setInt(29,MisFunciones.getIdExamenFisico());
            boolean resultado=  sentencia.execute();
            return resultado;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    private PreparedStatement seteandoSentenciaPreparada(FuncionesOrganicasGenerales examenFisico, PreparedStatement sentencia){
        try{
            sentencia.setInt(1,MisFunciones.getIdPaciente());
            sentencia.setString(2, examenFisico.getTxtSintomaPrin());
            sentencia.setString(3, examenFisico.getTxtMotivo());
            sentencia.setString(4, examenFisico.getTxtApariencia());
            sentencia.setDouble(5, Double.valueOf(examenFisico.getTxtPresion()));
            sentencia.setDouble(6, Double.valueOf(examenFisico.getTxtFrecuenciaC()));
            sentencia.setDouble(7, Double.valueOf(examenFisico.getTxtFrecuenciaR()));
            sentencia.setDouble(8, Double.valueOf(examenFisico.getTxtTemperatura()));
            sentencia.setString(9, examenFisico.getApetito());
            sentencia.setString(10, examenFisico.getSed());
            sentencia.setString(11, examenFisico.getSueno());
            sentencia.setString(12, examenFisico.getMiccion());
            sentencia.setString(13, examenFisico.getDefecacion());
            sentencia.setString(14, examenFisico.getTxtSistemaN());
            sentencia.setString(15, examenFisico.getTxtCabeza());
            sentencia.setString(16, examenFisico.getTxtOjos());
            sentencia.setString(17, examenFisico.getTxtNariz());
            sentencia.setString(18, examenFisico.getTxtBoca());
            sentencia.setString(19, examenFisico.getTxtCuello());
            sentencia.setString(20, examenFisico.getTxtRespiratorio());
            sentencia.setString(21, examenFisico.getTxtCardioVascular());
            sentencia.setString(22, examenFisico.getTxtDigestivo());
            sentencia.setString(23, examenFisico.getTxtOsteo());
            sentencia.setString(24, examenFisico.getTxtHemat());
            sentencia.setString(25, examenFisico.getTxtGenitou());
            sentencia.setString(26, examenFisico.getTxtInfatico());
            sentencia.setString(27, examenFisico.getTxtEndocrino());
            sentencia.setString(28, examenFisico.getTxtPielFaneras());
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return sentencia;
    }

    public FuncionesOrganicasGenerales(String apetito, String sed, String miccion, String defecacion, String sueno, String txtPielFaneras, String txtApariencia, String txtPresion, String txtFrecuenciaC, String txtFrecuenciaR, String txtTemperatura, String txtSistemaN, String txtCabeza, String txtOjos, String txtNariz, String txtBoca, String txtCuello, String txtRespiratorio, String txtCardioVascular, String txtDigestivo, String txtOsteo, String txtHemat, String txtMotivo, String txtSintomaPrin, String txtGenitou, String txtInfatico, String txtEndocrino) {
        this.apetito = apetito;
        this.sed = sed;
        this.miccion = miccion;
        this.defecacion = defecacion;
        this.sueno = sueno;
        this.txtPielFaneras = txtPielFaneras;
        this.txtApariencia = txtApariencia;
        this.txtPresion = txtPresion;
        this.txtFrecuenciaC = txtFrecuenciaC;
        this.txtFrecuenciaR = txtFrecuenciaR;
        this.txtTemperatura = txtTemperatura;
        this.txtSistemaN = txtSistemaN;
        this.txtCabeza = txtCabeza;
        this.txtOjos = txtOjos;
        this.txtNariz = txtNariz;
        this.txtBoca = txtBoca;
        this.txtCuello = txtCuello;
        this.txtRespiratorio = txtRespiratorio;
        this.txtCardioVascular = txtCardioVascular;
        this.txtDigestivo = txtDigestivo;
        this.txtOsteo = txtOsteo;
        this.txtHemat = txtHemat;
        this.txtMotivo = txtMotivo;
        this.txtSintomaPrin = txtSintomaPrin;
        this.txtGenitou = txtGenitou;
        this.txtInfatico = txtInfatico;
        this.txtEndocrino = txtEndocrino;
    }

    public String getId_examen_fisico() {
        return id_examen_fisico;
    }

    public void setId_examen_fisico(String id_examen_fisico) {
        this.id_examen_fisico = id_examen_fisico;
    }

    public String getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(String id_paciente) {
        this.id_paciente = id_paciente;
    }

    public static FuncionesOrganicasGenerales BuscarRegistro(){
        ResultSet resultado = null;
        try{
            PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement(
                    "SELECT * FROM examenes_fisicos " +
                            "inner join expedientes on expedientes.id_expediente=examenes_fisicos.id_paciente" +
                            " WHERE id_examen_fisico = ? ;"
            );
            sentencia.setInt(1,MisFunciones.getIdExamenFisico());
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                return FuncionesOrganicasGenerales.crearInstancia(resultado);
            }
        }catch (SQLException e){
            System.err.println("hola  : " + e.getMessage());
        }
        return null;
    }

    private static FuncionesOrganicasGenerales crearInstancia(ResultSet resultado) {
        FuncionesOrganicasGenerales examenFisico = null;
        try {
            examenFisico = new FuncionesOrganicasGenerales(
                    resultado.getString("apetito"),
                    resultado.getString("sed"),
                    resultado.getString("miccion"),
                    resultado.getString("defecacion"),
                    resultado.getString("sueño"),
                    resultado.getString("piel_faneras"),
                    resultado.getString("apariencia_general"),
                    resultado.getString("presion_arterial"),
                    resultado.getString("frecuencia_cardiaca"),
                    resultado.getString("frecuencia_respiratoria"),
                    resultado.getString("temperatura"),
                    resultado.getString("snc"),
                    resultado.getString("cabeza"),
                    resultado.getString("ojos"),
                    resultado.getString("nariz_paranasales"),
                    resultado.getString("boca_faringe"),
                    resultado.getString("cuello"),
                    resultado.getString("respiratorio"),
                    resultado.getString("cardiovascular"),
                    resultado.getString("digestivo"),
                    resultado.getString("osteomuscular"),
                    resultado.getString("hematologico"),
                    resultado.getString("motivo_consulta"),
                    resultado.getString("sintoma_principal"),
                    resultado.getString("genitoutario"),
                    resultado.getString("infatico"),
                    resultado.getString("endocrino")
            );
            examenFisico.setId_examen_fisico(resultado.getString("id_examen_fisico"));
            examenFisico.setCreacionExamen(resultado.getString("examenes_fisicos.creacion"));
            examenFisico.setId_paciente(resultado.getString("id_expediente"));
            if (resultado.getString("identidad")!= null){
                examenFisico.setIdentidad(resultado.getString("identidad"));
            }
            if (resultado.getString("nombres")!= null){
                examenFisico.setNombresPaciente(resultado.getString("nombres"));
            }
            if (resultado.getString("apellidos")!= null){
                examenFisico.setApellidosPaciente(resultado.getString("apellidos"));
            }
        } catch (SQLException e) {
            System.err.println("Algo salio mal " + e.getMessage());
        }
        return examenFisico;
    }

    public static ObservableList<FuncionesOrganicasGenerales> llenarTableView(ObservableList<FuncionesOrganicasGenerales> lista){
        PreparedStatement sentencia = null;
        try {
            sentencia = Conexion.abrirConexion().prepareStatement(
                    "SELECT * FROM examenes_fisicos " +
                            "inner join expedientes on expedientes.id_expediente=" +
                            "examenes_fisicos.id_paciente;"
            );
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                lista.add(FuncionesOrganicasGenerales.crearInstancia(resultado));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return lista;
    }

    public static ObservableList<FuncionesOrganicasGenerales> busquedaPorNombreApellidouIdentidad(ObservableList<FuncionesOrganicasGenerales> lista, String dato){
        PreparedStatement sentencia = null;
        try {
            sentencia = Conexion.abrirConexion().prepareStatement(
                    "SELECT * FROM examenes_fisicos " +
                            "inner join expedientes on expedientes.id_expediente=" +
                            "examenes_fisicos.id_paciente where " +
                            "expedientes.identidad like ? " +
                            "or expedientes.nombres like ? or expedientes.apellidos like ?;"
            );
            sentencia.setString(1,dato + "%");
            sentencia.setString(2,dato + "%");
            sentencia.setString(3,dato + "%");
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                lista.add(FuncionesOrganicasGenerales.crearInstancia(resultado));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return lista;
    }

    public String getApetito() {
        return apetito;
    }

    public String getSed() {
        return sed;
    }

    public String getMiccion() {
        return miccion;
    }

    public String getDefecacion() {
        return defecacion;
    }

    public String getSueno() {
        return sueno;
    }

    public String getTxtPielFaneras() {
        return txtPielFaneras;
    }

    public String getTxtApariencia() {
        return txtApariencia;
    }

    public String getTxtPresion() {
        return txtPresion;
    }

    public String getTxtFrecuenciaC() {
        return txtFrecuenciaC;
    }

    public String getTxtFrecuenciaR() {
        return txtFrecuenciaR;
    }

    public String getTxtTemperatura() {
        return txtTemperatura;
    }

    public String getTxtSistemaN() {
        return txtSistemaN;
    }

    public String getTxtCabeza() {
        return txtCabeza;
    }

    public String getTxtOjos() {
        return txtOjos;
    }

    public String getTxtNariz() {
        return txtNariz;
    }

    public String getTxtBoca() {
        return txtBoca;
    }

    public String getTxtCuello() {
        return txtCuello;
    }

    public String getTxtRespiratorio() {
        return txtRespiratorio;
    }

    public String getTxtCardioVascular() {
        return txtCardioVascular;
    }

    public String getTxtDigestivo() {
        return txtDigestivo;
    }

    public String getTxtOsteo() {
        return txtOsteo;
    }

    public String getTxtHemat() {
        return txtHemat;
    }

    public String getTxtMotivo() {
        return txtMotivo;
    }

    public String getTxtSintomaPrin() {
        return txtSintomaPrin;
    }

    public String getTxtGenitou() {
        return txtGenitou;
    }

    public String getTxtInfatico() {
        return txtInfatico;
    }

    public String getTxtEndocrino() {
        return txtEndocrino;
    }
}
