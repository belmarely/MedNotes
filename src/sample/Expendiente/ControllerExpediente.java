package sample.Expendiente;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.modelos.Expendiente;
import sample.modelos.FuncionesOrganicasGenerales;
import sample.modelos.MisFunciones;

public class ControllerExpediente {

    private String alcoholismo = "";//capturarValorAlcoholismo();
    private String tabaquismo =""; //capturarValorTabaquismo();
    private String otraDroga = "";//capturarValorOtraDroga();
private String sexo ="M";
    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtIdentidad;
    @FXML
    private ComboBox sex;
    @FXML
    private TextField txtLugarNacimiento;
    @FXML
    private TextField txtFechaNacimiento;
    @FXML
    private ComboBox nacionalidad;

    @FXML
    private TextField direccion;

    @FXML
    private TextField edad;

    @FXML
    private TextField telefono;
    @FXML

    private TextField seguridadSocial;
    @FXML

    private ComboBox sangre;
    @FXML

    private CheckBox checkAlcoholismo;
    @FXML
    private CheckBox chechTabaquismo;

    @FXML
    private CheckBox checkOtraDroga;

    @FXML
    private TextField txtHospitalarios;

    @FXML
    private TextField txtAlergias;

    @FXML
    private TextField txtTraumas;
    @FXML

    private Button btnCancelar;
    @FXML

    private Button btnGuardar;


    public void btnCancelar() {

        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();

    }



    public void BotonGuardarActualizar(ActionEvent actionEvent){

        if (MisFunciones.getIdPaciente()!=0) {
            Actualizar();
        } else {
            Guardar();
        }

    }


    private void Actualizar() {

        if (comprobarCamposVacios()) {
            Expendiente actualizarExpediente = crearIntancia();
            Expendiente.Actualizar(actualizarExpediente);
            mensaje("Datos Actualizados exitosamente");
            btnCancelar();


        }else{
            mensaje("Campos Vacios");
        }

    }

    private String capturarValorAlcoholismo(){
        if (checkAlcoholismo.isSelected()){
            alcoholismo = "Si";
        }else {
            alcoholismo = "No";
        }
        return alcoholismo;
    }

    private String capturarValorTabaquismo(){
        if (chechTabaquismo.isSelected()){
            tabaquismo = "Si";
        }else {
            tabaquismo = "No";
        }
        return tabaquismo;
    }

    private String capturarValorOtraDroga(){
        if (checkOtraDroga.isSelected()){
            otraDroga = "Si";
        }else {
            otraDroga = "No";
        }
        return otraDroga;
    }


    private boolean comprobarCamposVacios(){


        if (!txtNombre.getText().isBlank() &&
                !txtApellido.getText().isBlank() &&
                !txtIdentidad.getText().isBlank() &&
                !txtFechaNacimiento.getText().isBlank() &&
                !txtAlergias.getText().isBlank() &&
                !txtHospitalarios.getText().isBlank() &&
                !txtLugarNacimiento.getText().isBlank() &&
                !txtTraumas.getText().isBlank() &&
                !direccion.getText().isBlank() &&
                !edad.getText().isBlank() &&
                !seguridadSocial.getText().isBlank()) //&&
                //!checkAlcoholismo.isSelected() &&
                //!chechTabaquismo.isSelected() &&
                //!checkOtraDroga.isSelected()){
        {
            return true;
        }
        return false;

    }



    public Expendiente crearIntancia(){


        Expendiente expedienteInstancia = new
                Expendiente(
                txtNombre.getText(),txtApellido.getText(),telefono.getText(),txtIdentidad.getText(),sexo,
                edad.getText(),txtLugarNacimiento.getText(),
                txtFechaNacimiento.getText(), direccion.getText(),
                seguridadSocial.getText(),nacionalidad.getVisibleRowCount(),
                sangre.getAccessibleHelp(),tabaquismo,alcoholismo,otraDroga,
                txtHospitalarios.getText(),txtAlergias.getText(), txtTraumas.getText());

        return expedienteInstancia;

    }


    public void Guardar() {

        if (comprobarCamposVacios()) {
            Expendiente expediente = crearIntancia();
            Expendiente.Guardar(expediente);
            mensaje("Datos guardados exitosamente");
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


    public void cerrar(ActionEvent actionEvent) {


        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();


    }







}
