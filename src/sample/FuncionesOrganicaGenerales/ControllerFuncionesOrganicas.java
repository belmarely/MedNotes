package sample.FuncionesOrganicaGenerales;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.libs.Conexion;
import sample.modelos.MisFunciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ControllerFuncionesOrganicas {

    @FXML
    private TextField txtPielFaneras;
    @FXML
    private TextArea txtApariencia;
    @FXML
    private TextField txtPresion;
    @FXML
    private TextField txtFrecuenciaC;
    @FXML
    private TextField txtFrecuenciaR;
    @FXML
    private TextField txtTemperatura;
    @FXML
    private TextField txtSistemaN;
    @FXML
    private TextField txtCabeza;
    @FXML
    private TextField txtOjos;
    @FXML
    private TextField txtNariz;
    @FXML
    private TextField txtBoca;
    @FXML
    private TextField txtCuello;
    @FXML
    private TextField txtRespiratorio;
    @FXML
    private TextField txtCardioVascular;
    @FXML
    private TextField txtDigestivo;
    @FXML
    private TextField txtOseo;
    @FXML
    private TextField txtHemat;
    @FXML
    private TextArea txtMotivo;
    @FXML
    private TextArea txtSintomaPrin;
    @FXML
    private TextField txtGenitou;
    @FXML
    private TextField txtInfatico;
    @FXML
    private TextField txtEndocrino;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnGuardar;
    @FXML
    private RadioButton sueno1;
    @FXML
    private RadioButton sueno2;
    @FXML
    private RadioButton sueno3;
    @FXML
    private RadioButton defecacion1;
    @FXML
    private RadioButton defecacion2;
    @FXML
    private RadioButton defecacion3;
    @FXML
    private RadioButton miccion1;
    @FXML
    private RadioButton miccion2;
    @FXML
    private RadioButton miccion3;
    @FXML
    private RadioButton sed1;
    @FXML
    private RadioButton sed2;
    @FXML
    private RadioButton sed3;
    @FXML
    private RadioButton apetito1;
    @FXML
    private RadioButton apetito2;
    @FXML
    private RadioButton apetito3;
    @FXML

    private ToggleGroup agrupacion1;
    private ToggleGroup agrupacion2;
    private ToggleGroup agrupacion3;
    private ToggleGroup agrupacion4;
    private ToggleGroup agrupacion5;
    private ScrollBar scrolll;

    @FXML
    private void initialize() {
        relacionesRadioBotones();
    }


    private void relacionesRadioBotones() {
        agrupacion1 = new ToggleGroup();
        apetito1.setToggleGroup(agrupacion1);
        apetito2.setToggleGroup(agrupacion1);
        apetito3.setToggleGroup(agrupacion1);
        agrupacion2 = new ToggleGroup();
        sed1.setToggleGroup(agrupacion2);
        sed2.setToggleGroup(agrupacion2);
        sed3.setToggleGroup(agrupacion2);
        agrupacion3 = new ToggleGroup();
        miccion1.setToggleGroup(agrupacion3);
        miccion2.setToggleGroup(agrupacion3);
        miccion3.setToggleGroup(agrupacion3);
        agrupacion4 = new ToggleGroup();
        defecacion1.setToggleGroup(agrupacion4);
        defecacion2.setToggleGroup(agrupacion4);
        defecacion3.setToggleGroup(agrupacion4);
        agrupacion5 = new ToggleGroup();
        sueno1.setToggleGroup(agrupacion5);
        sueno2.setToggleGroup(agrupacion5);
        sueno3.setToggleGroup(agrupacion5);
    }
    public void btnCancelar(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
    public void Guardar(ActionEvent actionEvent) {
        String apetito = "";
        String sed = "";
        String miccion = "";
        String defecacion = "";
        String sueno = "";

        if (agrupacion1.getSelectedToggle() != null) {
            apetito = agrupacion1.getSelectedToggle().getUserData().toString();
        }
        if (agrupacion1.getSelectedToggle() != null) {
            sed = agrupacion2.getSelectedToggle().getUserData().toString();
        }
        if (agrupacion1.getSelectedToggle() != null) {
            miccion = agrupacion3.getSelectedToggle().getUserData().toString();
        }
        if (agrupacion1.getSelectedToggle() != null) {
            defecacion = agrupacion4.getSelectedToggle().getUserData().toString();
        }
        if (agrupacion1.getSelectedToggle() != null) {
            sueno = agrupacion5.getSelectedToggle().getUserData().toString();
        }

        if (
                !txtPielFaneras.getText().isBlank() &&
                        !txtPresion.getText().isBlank() &&
                        !txtFrecuenciaC.getText().isBlank() &&
                        !txtFrecuenciaR.getText().isBlank() &&
                        !txtSistemaN.getText().isBlank() &&
                        !txtCabeza.getText().isBlank() &&
                        !txtOjos.getText().isBlank() &&
                        !txtNariz.getText().isBlank() &&
                        !txtBoca.getText().isBlank() &&
                        !txtCuello.getText().isBlank() &&
                        !txtCardioVascular.getText().isBlank() &&
                        !txtDigestivo.getText().isBlank() &&
                        !txtOseo.getText().isBlank() &&
                        !txtHemat.getText().isBlank() &&
                        !txtMotivo.getText().isBlank() &&
                        !txtSintomaPrin.getText().isBlank() &&
                        !txtGenitou.getText().isBlank() &&
                        !txtInfatico.getText().isBlank() &&
                        !txtEndocrino.getText().isBlank()&&
                        !txtApariencia.getText().isBlank()&&
                        !txtTemperatura.getText().isBlank()&&
                        !txtRespiratorio.getText().isBlank()&&
                        !txtOseo.getText().isBlank()
        ) {

            try {
                PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement(
                        "INSERT INTO `registro_medico`.`examenes_fisicos` (`id_paciente`" +
                                ", `sintoma_principal`, `motivo_consulta`, `apariencia_general`" +
                                ", `presion_arterial`, `frecuencia_cardiaca`," +
                                " `frecuencia_respiratoria`, `temperatura`, `apetito`," +
                                " `sed`, `sueño`, `miccion`, `defecacion`, `snc`, `cabeza`," +
                                " `ojos`, `nariz_paranasales`, `boca_faringe`, `cuello`," +
                                " `respiratorio`, `cardiovascular`, `digestivo`, `osteomuscular`," +
                                " `hematologico`, `genitoutario`, `infatico`, `endocrino`," +
                                " `piel_faneras`) VALUES ('?', '?', '?', '?', '?'," +
                                " '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?'," +
                                " '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?');"
                );
                sentencia.setInt(1, MisFunciones.getIdPaciente());
                sentencia.setString(2, txtSintomaPrin.getText());
                sentencia.setString(3, txtMotivo.getText());
                sentencia.setString(4, txtApariencia.getText());
                sentencia.setString(5, txtPresion.getText());
                sentencia.setString(6, txtFrecuenciaC.getText());
                sentencia.setString(7, txtFrecuenciaR.getText());
                sentencia.setString(8, txtTemperatura.getText());
                sentencia.setString(9, apetito);
                sentencia.setString(10, sed);
                sentencia.setString(11, sueno);
                sentencia.setString(12, miccion);
                sentencia.setString(13, defecacion);
                sentencia.setString(14, txtSistemaN.getText());
                sentencia.setString(15, txtCabeza.getText());
                sentencia.setString(16, txtOjos.getText());
                sentencia.setString(17, txtNariz.getText());
                sentencia.setString(18, txtBoca.getText());
                sentencia.setString(19, txtCuello.getText());
                sentencia.setString(20, txtRespiratorio.getText());
                sentencia.setString(21, txtCardioVascular.getText());
                sentencia.setString(22, txtDigestivo.getText());
                sentencia.setString(23, txtOseo.getText());
                sentencia.setString(24, txtHemat.getText());
                sentencia.setString(25, txtGenitou.getText());
                sentencia.setString(26, txtInfatico.getText());
                sentencia.setString(27, txtEndocrino.getText());
                sentencia.setString(28, txtPielFaneras.getText());
                ResultSet resultado = sentencia.executeQuery();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }else{

        }

    }

}