package sample.modelos;

import sample.libs.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionesOrganicasGenerales {
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

    public static FuncionesOrganicasGenerales BuscarRegistro(){
        ResultSet resultado = null;
        try{
            PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement(
                    "SELECT * FROM examenes_fisicos WHERE id_examen_fisico= ? ;"
            );
            sentencia.setInt(1,3);
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
        } catch (SQLException e) {
            System.err.println("Algo salio mal " + e.getMessage());
        }
        return examenFisico;
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
