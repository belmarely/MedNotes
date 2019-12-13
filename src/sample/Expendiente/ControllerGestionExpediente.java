package sample.Expendiente;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.modelos.Expendiente;
import sample.modelos.MisFunciones;
import sample.modelos.RegistroCitas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerGestionExpediente implements Initializable {

    @FXML
    private TableView<Expendiente> tableViewExpediente;

    @FXML
    private TableColumn<Expendiente, String> colID;

    @FXML
    private TableColumn<Expendiente, String> colIdentidad;

    @FXML
    private TableColumn<Expendiente, String> colNombres;

    @FXML
    private TableColumn<Expendiente, String> colApellidos;

    private ObservableList<Expendiente> listaExpediente;

    private String dato;
    private String id_paciente;

    @FXML
    private TextField busqueda;

    public void obtenerId(MouseEvent mouseEvent) {
        try {
            id_paciente = tableViewExpediente.getSelectionModel().getSelectedItem().getId_expediente();
            MisFunciones.setIdPaciente(Integer.valueOf(id_paciente));
        }catch (NullPointerException e){
            mensaje("Seleccione un campo, no seleccione campos vacios");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        actualizarTableViewLista();
        busqueda.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                dato= busqueda.getText();
                buscarPorNombreOIdentidad();
            }
        });
    }

    public void actualizarTableViewLista(){
        listaExpediente = FXCollections.observableArrayList();
        listaExpediente =  Expendiente.llenarTableView(listaExpediente);
        tableViewExpediente.setItems(listaExpediente);
        columnasTableViewUsuarios();
    }

    public void buscarPorNombreOIdentidad(){
        listaExpediente = FXCollections.observableArrayList();
        listaExpediente =  Expendiente.buscarIDYNombre(listaExpediente,dato);
        tableViewExpediente.setItems(listaExpediente);
        columnasTableViewUsuarios();
    }

    private void columnasTableViewUsuarios() {
        colID.setCellValueFactory(new PropertyValueFactory<>("id_expediente"));
        colIdentidad.setCellValueFactory(new PropertyValueFactory<>("identidad"));
        colNombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
    }

    public void abrirFormularioNuevo(ActionEvent actionEvent) {
        try{
            MisFunciones.setIdPaciente(0);
            abrirFormulario();
        }catch (Exception e){

        }
    }

    public void abrirFormularioEditar(ActionEvent actionEvent) {
        if (MisFunciones.getIdPaciente()==0){
            mensaje("No ha seleccionado ninguna cita");
        }else{
            try{
                abrirFormulario();
            }catch (Exception e){
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

    public void abrirFormulario()  {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("expediente.fxml"));
            Stage sStage = new Stage();
            sStage.setTitle("Med Notes");
            sStage.setScene(new Scene(root, 400, 475));
            sStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
