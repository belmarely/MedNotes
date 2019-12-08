package sample.RegistroCita;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import sample.modelos.MisFunciones;
import sample.modelos.RegistroCitas;

public class ControllerRegistroCita {
    private String fechaConcatenada;
    @FXML
    private TextField identidad;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellido;
    @FXML
    private TextField dia;
    @FXML
    private ComboBox comboId;
    @FXML
    private Button Cancelar;
    @FXML
    private ScrollBar scrolll;

    @FXML
    private void initialize() {
        //  relacionesRadioBotones();
        //    llenarCampos();
    }

    public void Cancelar() {
        Stage stage = (Stage) Cancelar.getScene().getWindow();
        stage.close();
    }

    private boolean comprobarCamposVacios(){

        if (!identidad.getText().isBlank() &&
                !nombre.getText().isBlank() &&
                !apellido.getText().isBlank() &&
                !dia.getText().isBlank() &&
                !comboId.getItems().isEmpty()){
            return true;
        }
        return false;
    }

    public RegistroCitas crearIntancia(){
        RegistroCitas cita = new
                RegistroCitas(fechaConcatenada);
        return cita;
    }

    public void Guardar() {
        if (comprobarCamposVacios()) {
            RegistroCitas cita = crearIntancia();
            RegistroCitas.Guardar(cita);
            mensaje("Datos guardados exitosamente");
            Cancelar();

        }else{
            mensaje("Campos Vacios");
        }
    }
    public void BotonGuardarActualizar(ActionEvent actionEvent){
        if (MisFunciones.getIdExamenFisico()!=0) {
            System.out.println("Pronto actualizara");
            //Actualizar();
        } else {
            Guardar();
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
