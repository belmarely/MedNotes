package sample.Expendiente;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.modelos.Expendiente;
import sample.modelos.FuncionesOrganicasGenerales;
import sample.modelos.MisFunciones;
import sample.modelos.RegistroCitas;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class ControllerExpediente implements Initializable {

    private String alcoholismo = "";//capturarValorAlcoholismo();
    private String tabaquismo =""; //capturarValorTabaquismo();
    private String otraDroga = "";//capturarValorOtraDroga();
    private String sangreTipo = "";//capturarValorOtraDroga();
    private String sexo ="";
    private int pais;

    private ObservableList<Expendiente> listaPaises;
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
    private ComboBox<Expendiente> nacionalidad;

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

    @FXML
    private DatePicker datapickDia;
    private String fecha;


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

    private String capturarSexo (){
        try {
            sexo = sex.getSelectionModel().getSelectedItem().toString();
            return sexo;
        }catch (Exception e){
            mensaje("No selecciono un campo");
        }
        return "";
    }

    private int capturarPais (){
        pais = nacionalidad.getSelectionModel(). getSelectedItem().getId();
        return pais;
    }

    private String capturarTipoSangre (){
        sangreTipo = sangre.getSelectionModel(). getSelectedItem().toString();
        return sangreTipo;

    }

    private void llenarComboboxPaises() {
        listaPaises = FXCollections.observableArrayList();
        Expendiente.comboboxPaises(listaPaises);
        nacionalidad.setItems(listaPaises);
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
                !txtIdentidad.getText().isBlank()  &&
                !txtAlergias.getText().isBlank() &&
                !txtHospitalarios.getText().isBlank() &&
                !txtLugarNacimiento.getText().isBlank() &&
                !txtTraumas.getText().isBlank() &&
                !direccion.getText().isBlank() &&
                !edad.getText().isBlank() &&
                !seguridadSocial.getText().isBlank())

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
                fecha, direccion.getText(),
                seguridadSocial.getText(),pais,
                sangreTipo,tabaquismo,alcoholismo,otraDroga,
                txtHospitalarios.getText(),txtAlergias.getText(), txtTraumas.getText());

        return expedienteInstancia;

    }


    public void Guardar() {
        if (!comprobarIdentidad(txtIdentidad.getText())) {
            if (comprobarCamposVacios()) {
                capturarValorTabaquismo();
                capturarValorAlcoholismo();
                capturarValorOtraDroga();
                capturarSexo();
                capturarTipoSangre();
                capturarPais();
                convertirFecha();
                Expendiente expediente = crearIntancia();
                Expendiente.Guardar(expediente);
                mensaje("Datos guardados exitosamente");
                btnCancelar();

            } else {
                mensaje("Campos Vacios");
            }

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



    public boolean comprobarIdentidad(String identidad){

        if(Expendiente.confirmarIdentidad(identidad)){
            mensaje("Ya existe un expediente con el mismo numero de identidad");
        return Expendiente.confirmarIdentidad(identidad);
        }
        return Expendiente.confirmarIdentidad(identidad);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        llenarComboboxPaises();
    }

    private void conversionFechaSqlaFechaUtil(Expendiente fechaNacimiento){
       // Date fecha = fechaNacimiento.getFechaNacimiento();
        //datapickDia.setValue(fecha.toLocalDate());
    }
}
