package sample.FuncionesOrganicaGenerales;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.modelos.FuncionesOrganicasGenerales;
import sample.modelos.MisFunciones;


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
        llenarCampos();
    }

    private void llenarCampos() {
        if (MisFunciones.getIdExamenFisico()!= 0){
            FuncionesOrganicasGenerales examenFisico = FuncionesOrganicasGenerales.BuscarRegistro();
            txtPresion.setText(examenFisico.getTxtPresion());
            txtSistemaN.setText(examenFisico.getTxtSistemaN());
            txtPielFaneras.setText(examenFisico.getTxtPielFaneras());
            txtApariencia.setText(examenFisico.getTxtApariencia());
            txtFrecuenciaC.setText(examenFisico.getTxtFrecuenciaC());
            txtFrecuenciaR.setText(examenFisico.getTxtFrecuenciaR());
            txtTemperatura.setText(examenFisico.getTxtTemperatura());
            txtCabeza.setText(examenFisico.getTxtCabeza());
            txtOjos.setText(examenFisico.getTxtOjos());
            txtNariz.setText(examenFisico.getTxtNariz());
            txtBoca.setText(examenFisico.getTxtBoca());
            txtCuello.setText(examenFisico.getTxtCuello());
            txtRespiratorio.setText(examenFisico.getTxtRespiratorio());
            txtCardioVascular.setText(examenFisico.getTxtCardioVascular());
            txtDigestivo.setText(examenFisico.getTxtDigestivo());
            txtOsteo.setText(examenFisico.getTxtOsteo());
            txtHemat.setText(examenFisico.getTxtHemat());
            txtMotivo.setText(examenFisico.getTxtMotivo());
            txtSintomaPrin.setText(examenFisico.getTxtSintomaPrin());
            txtGenitou.setText(examenFisico.getTxtGenitou());
            txtInfatico.setText(examenFisico.getTxtInfatico());
            txtEndocrino.setText(examenFisico.getTxtEndocrino());
            llenarRadioBotones(examenFisico);
            btnGuardar.setText("Actualizar");
        }
    }


    private void llenarRadioBotones(FuncionesOrganicasGenerales examenFisico){
        if (examenFisico.getApetito().equals("Disminuido")){
            apetito1.setSelected(true);
        } else if(examenFisico.getApetito().equals("Aumentado")){
            apetito2.setSelected(true);
        } else if (examenFisico.getApetito().equals("Sin Alteracion")){
            apetito3.setSelected(true);
        }
        if (examenFisico.getSed().equals("Disminuido")){
            sed1.setSelected(true);
        } else if(examenFisico.getSed().equals("Aumentado")){
            sed2.setSelected(true);
        } else if (examenFisico.getSed().equals("Sin Alteracion")){
            sed3.setSelected(true);
        }
        if (examenFisico.getSueno().equals("Disminuido")){
            sueno1.setSelected(true);
        } else if(examenFisico.getSueno().equals("Aumentado")){
            sueno2.setSelected(true);
        } else if (examenFisico.getSueno().equals("Sin Alteracion")){
            sueno3.setSelected(true);
        }
        if (examenFisico.getDefecacion().equals("Disminuido")){
            defecacion1.setSelected(true);
            } else if(examenFisico.getDefecacion().equals("Aumentado")){
            defecacion2.setSelected(true);
        } else if (examenFisico.getDefecacion().equals("Sin Alteracion")){
            defecacion3.setSelected(true);
        }
        if (examenFisico.getMiccion().equals("Disminuido")){
            miccion1.setSelected(true);
        } else if(examenFisico.getMiccion().equals("Aumentado")){
            miccion2.setSelected(true);
        } else if (examenFisico.getMiccion().equals("Sin Alteracion")){
            miccion3.setSelected(true);
        }
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

    public void BotonGuardarActualizar(ActionEvent actionEvent){
        if (MisFunciones.getIdExamenFisico()!=0) {
            Actualizar();
        } else {
            Guardar();
        }
    }

    private void Actualizar() {
        seleccionRadioBoton();
        if (comprobarCamposVacios()) {
            FuncionesOrganicasGenerales examenFisico = crearIntancia();
            FuncionesOrganicasGenerales.Actualizar(examenFisico);
                mensaje("Datos Actualizados exitosamente");
                btnCancelar();

        }else{
            mensaje("Campos Vacios");
        }
    }

    private boolean comprobarCamposVacios(){

        if (!txtPielFaneras.getText().isBlank() &&
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
                !txtRespiratorio.getText().isBlank()){
            return true;
        }
        return false;
    }

    public FuncionesOrganicasGenerales crearIntancia(){
        FuncionesOrganicasGenerales examenFisico = new
                FuncionesOrganicasGenerales(
                apetito,sed,miccion,defecacion,sueno,
                txtPielFaneras.getText(),txtApariencia.getText(),
                txtPresion.getText(),txtFrecuenciaC.getText(),
                txtFrecuenciaR.getText(),txtTemperatura.getText(),
                txtSistemaN.getText(),txtCabeza.getText(),
                txtOjos.getText(),txtNariz.getText(),txtBoca.getText(),
                txtCuello.getText(),txtRespiratorio.getText(),
                txtCardioVascular.getText(),txtDigestivo.getText(),
                txtOsteo.getText(),txtHemat.getText(),txtMotivo.getText(),
                txtSintomaPrin.getText(),txtGenitou.getText(),
                txtInfatico.getText(),txtEndocrino.getText()
        );
        String id_paciente = String.valueOf(MisFunciones.getIdPaciente());
        examenFisico.setId_paciente(id_paciente);
        return examenFisico;
    }

    public void Guardar() {
        seleccionRadioBoton();
        if (comprobarCamposVacios()) {
            FuncionesOrganicasGenerales examenFisico = crearIntancia();
                FuncionesOrganicasGenerales.Guardar(examenFisico);
                    mensaje("Datos guardados exitosamente");
                    MisFunciones.setIdExamenFisico(0);
                    btnCancelar();

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


