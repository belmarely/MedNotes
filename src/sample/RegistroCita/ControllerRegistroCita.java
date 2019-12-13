package sample.RegistroCita;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import sample.modelos.Expendiente;
import sample.modelos.MisFunciones;
import sample.modelos.RegistroCitas;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class ControllerRegistroCita implements Initializable {
    @FXML
    private TextField identidad;
    @FXML
    private TextArea Diag;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellido;
    @FXML
    private DatePicker datapickDia;
    @FXML
    private ComboBox comboBoxHora;
    @FXML
    private Button Cancelar;
    @FXML
    private Button btnGuardar;

    private String fecha = "";
    private String id_paciente;
    private String fechaExistenteActualizacion;
    private String horaExistenteActualizacion;


    private void llenarCampos() {
        RegistroCitas cita = RegistroCitas.BuscarRegistro(MisFunciones.getId_citas());
        conversionFechaSqlaFechaUtil(cita);
        fechaExistenteActualizacion= cita.getDia();
        horaExistenteActualizacion = cita.getHora();
        int indice = Integer.valueOf(cita.getHora());
        comboBoxHora.getSelectionModel().select(indice);
        identidad.setText(cita.getIdentidad());
        nombre.setText(cita.getNombre());
        apellido.setText(cita.getApellido());
        btnGuardar.setText("Actualizar");
    }

    public void Cancelar() {
        Stage stage = (Stage) Cancelar.getScene().getWindow();
        stage.close();
    }

    private boolean comprobarCamposVacios(){
        if (!identidad.getText().isBlank() &&
                !nombre.getText().isBlank() &&
                !apellido.getText().isBlank() &&
                comboBoxHora.getSelectionModel().getSelectedItem() != null &&
                fecha != "" ){
            return true;
        }
        return false;
    }


    public boolean convertirFecha(){
        try{
                java.sql.Date gettedDatePickerDate = java.sql.Date.valueOf(datapickDia.getValue());
                fecha = gettedDatePickerDate.toString();
            return true;
        }catch (Exception e){
            mensaje("No ha ingresado la fecha");
            return false;
        }
    }

    public boolean validarExistenciaIdentidad(){
        boolean valor = Expendiente.confirmarIdentidad(identidad.getText());
        return valor;
    }

    public void Guardar() {
        if(convertirFecha()) {
            if (comprobarCamposVacios()) {
                if (!RegistroCitas.comprobarValidezDeCita(fecha, Integer.toString(comboBoxHora.getSelectionModel().getSelectedIndex()))) {
                    if (validarExistenciaIdentidad()) {
                        id_paciente = String.valueOf(Expendiente.obtenerIdPaciente(identidad.getText()));
                    } else {
                        if (Expendiente.CrearUsuarioUrgente(identidad.getText(), nombre.getText(), apellido.getText())) {
                            id_paciente = String.valueOf(Expendiente.obtenerIdPaciente(identidad.getText()));
                        } else {
                            mensaje("Error no se pude crear la cita");
                        }
                    }
                    RegistroCitas cita = new RegistroCitas(fecha, Integer.toString(comboBoxHora.getSelectionModel().getSelectedIndex()), id_paciente);
                    if (RegistroCitas.Guardar(cita)) {
                        mensaje("Datos guardados exitosamente");
                        Cancelar();
                    } else {
                        mensaje("Error");
                    }
                }else {
                    mensaje("Fecha ya ingresada");
                }
                }

            }else {
                mensaje("Campos Vacios");
        }
    }

    private void Actualizar() {
        if (convertirFecha()) {
            if (comprobarCamposVacios()) {
                if (!fechaExistenteActualizacion.equals(fecha) || !horaExistenteActualizacion.equals(Integer.toString(comboBoxHora.getSelectionModel().getSelectedIndex()))) {
                    if (RegistroCitas.comprobarValidezDeCita(fecha, Integer.toString(comboBoxHora.getSelectionModel().getSelectedIndex()))) {
                        mensaje("Campos ya existentes");
                    }else {
                        segundasValidaciones();
                    }
                } else {
                    segundasValidaciones();
                }
            }else {
                mensaje("campos vacios");
            }
        }
    }

        private void segundasValidaciones(){
                RegistroCitas citas = RegistroCitas.BuscarRegistro(MisFunciones.getId_citas());
                id_paciente = String.valueOf(Expendiente.obtenerIdPaciente(identidad.getText()));
                if (!id_paciente.equals("0")){
                    citas.setId_paciente(id_paciente);
                    citas.setDia(fecha);
                    citas.setHora(Integer.toString(comboBoxHora.getSelectionModel().getSelectedIndex()));
                    if (RegistroCitas.Actualizar(citas)) {
                        mensaje("Datos Actualizados Correctamente");
                    } else {
                        mensaje("Ingrese correctamente los campos");
                    }
                } else {
                    Expendiente.CrearUsuarioUrgente(identidad.getText(), nombre.getText(), apellido.getText());
                    id_paciente = String.valueOf(Expendiente.obtenerIdPaciente(identidad.getText()));
                    RegistroCitas cita = new RegistroCitas(fecha, Integer.toString(comboBoxHora.getSelectionModel().getSelectedIndex()), id_paciente);
                    RegistroCitas.Actualizar(cita);
                    mensaje("Datos Actualizados Correctamente");
                }
                MisFunciones.setId_citas(0);
                Cancelar();
            }






    private void conversionFechaSqlaFechaUtil(RegistroCitas cita){
        Date fecha = cita.getDiaFechaTipoSql();
        datapickDia.setValue(fecha.toLocalDate());
    }

    private void mensaje(String mensaje){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    public void Cancelarr(ActionEvent actionEvent) {
        Cancelar();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (MisFunciones.getId_citas()!=0) {
            llenarCampos();
        }
    }

    public void BotonActualizarGuardar(ActionEvent actionEvent) {
        if (MisFunciones.getId_citas()!=0) {
            Actualizar();

        } else {
            Guardar();
        }
    }
}

