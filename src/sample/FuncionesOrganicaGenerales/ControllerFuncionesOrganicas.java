package sample.FuncionesOrganicaGenerales;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sample.libs.Conexion;
import sample.modelos.MisFunciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ControllerFuncionesOrganicas {
    private String apetito = "";
    private String sed = "";
    private String miccion = "";
    private String defecacion = "";
    private String sueno = "";
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
    private TextField txtOsteo;
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
    ToggleGroup right;

    private ToggleGroup agrupacion1;
    private ToggleGroup agrupacion2;
    private ToggleGroup agrupacion3;
    private ToggleGroup agrupacion4;
    private ToggleGroup agrupacion5;
    @FXML
    private ScrollBar scrolll;

    @FXML
    private void initialize() {
        relacionesRadioBotones();
    }


    private void relacionesRadioBotones() {
        ToggleGroup agrupacion1 = new ToggleGroup();
        apetito1.setToggleGroup(agrupacion1);
        apetito2.setToggleGroup(agrupacion1);
        apetito3.setToggleGroup(agrupacion1);
        ToggleGroup agrupacion2 = new ToggleGroup();
        sed1.setToggleGroup(agrupacion2);
        sed2.setToggleGroup(agrupacion2);
        sed3.setToggleGroup(agrupacion2);
        ToggleGroup agrupacion3 = new ToggleGroup();
        miccion1.setToggleGroup(agrupacion3);
        miccion2.setToggleGroup(agrupacion3);
        miccion3.setToggleGroup(agrupacion3);
        ToggleGroup agrupacion4 = new ToggleGroup();
        defecacion1.setToggleGroup(agrupacion4);
        defecacion2.setToggleGroup(agrupacion4);
        defecacion3.setToggleGroup(agrupacion4);
        ToggleGroup agrupacion5 = new ToggleGroup();
        sueno1.setToggleGroup(agrupacion5);
        sueno2.setToggleGroup(agrupacion5);
        sueno3.setToggleGroup(agrupacion5);
    }
    public void btnCancelar() {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }

    public void seleccionRadioBoton(){
        if (apetito1.isSelected()) {
            apetito= "Disminuido";
        }else if (apetito2.isSelected()){
            apetito= "Aumentado";
        } else if (apetito3.isSelected()){
            apetito= "Sin Alteracion";
        }
        if (sed1.isSelected()) {
            sed= "Disminuido";
        }else if (sed2.isSelected()){
            sed= "Aumentado";
        } else if (sed3.isSelected()){
            sed= "Sin Alteracion";
        }
        if (miccion1.isSelected()) {
            miccion= "Disminuido";
        }else if (miccion2.isSelected()){
            miccion= "Aumentado";
        } else if (miccion3.isSelected()){
            miccion= "Sin Alteracion";
        }
        if (defecacion1.isSelected()) {
            defecacion= "Disminuido";
        }else if (defecacion2.isSelected()){
            defecacion= "Aumentado";
        } else if (defecacion3.isSelected()){
            defecacion= "Sin Alteracion";
        }

        if (sueno1.isSelected()) {
        sueno= "Disminuido";
        }else if (sueno2.isSelected()){
            sueno= "Aumentado";
        } else if (sueno3.isSelected()){
            sueno= "Sin Alteracion";
        }
    }
    public void Guardar(ActionEvent actionEvent) {

        seleccionRadioBoton();
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
                        !txtOsteo.getText().isBlank() &&
                        !txtHemat.getText().isBlank() &&
                        !txtMotivo.getText().isBlank() &&
                        !txtSintomaPrin.getText().isBlank() &&
                        !txtGenitou.getText().isBlank() &&
                        !txtInfatico.getText().isBlank() &&
                        !txtEndocrino.getText().isBlank()&&
                        !txtApariencia.getText().isBlank()&&
                        !txtTemperatura.getText().isBlank()&&
                        !txtRespiratorio.getText().isBlank()
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
                                " `piel_faneras`) VALUES (?, ?, ?, ?, ?," +
                                " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
                                " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"
                );
                int numero1= 1;
                sentencia.setInt(1,numero1);
                sentencia.setString(2, txtSintomaPrin.getText());
                sentencia.setString(3, txtMotivo.getText());
                sentencia.setString(4, txtApariencia.getText());
                sentencia.setDouble(5, Double.valueOf(txtPresion.getText()));
                sentencia.setDouble(6, Double.valueOf(txtFrecuenciaC.getText()));
                sentencia.setDouble(7, Double.valueOf(txtFrecuenciaR.getText()));
                sentencia.setDouble(8, Double.valueOf(txtTemperatura.getText()));
                sentencia.setString(9, apetito);
                sentencia.setString(10, sed);
                sentencia.setString(11, sueno);
                sentencia.setString(12, miccion);
                sentencia.setString(13, defecacion);
                sentencia.setString(14, txtSistemaN.getText().toString());
                sentencia.setString(15, txtCabeza.getText().toString());
                sentencia.setString(16, txtOjos.getText().toString());
                sentencia.setString(17, txtNariz.getText().toString());
                sentencia.setString(18, txtBoca.getText().toString());
                sentencia.setString(19, txtCuello.getText().toString());
                sentencia.setString(20, txtRespiratorio.getText().toString());
                sentencia.setString(21, txtCardioVascular.getText().toString());
                sentencia.setString(22, txtDigestivo.getText().toString());
                sentencia.setString(23, txtOsteo.getText().toString());
                sentencia.setString(24, txtHemat.getText().toString());
                sentencia.setString(25, txtGenitou.getText().toString());
                sentencia.setString(26, txtInfatico.getText().toString());
                sentencia.setString(27, txtEndocrino.getText().toString());
                sentencia.setString(28, txtPielFaneras.getText().toString());
                sentencia.execute();
                mensaje("Datos guardados exitosamente");
                btnCancelar();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }else{
            mensaje("Campos Vacios");
        }

    }

    private void mensaje(String mensaje){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}