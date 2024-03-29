package sample.RegistroCita;

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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.modelos.FuncionesOrganicasGenerales;
import sample.modelos.MisFunciones;
import sample.modelos.RegistroCitas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorGestionCitas implements Initializable {
    private int id_cita;
    private int id_expediente;
    private String vacio = "";

    final static String[] CAMPOS_VALIDOS = {
            "8:00 AM", "8:30 AM", "9:00 AM", "9:30 AM",
            "10:00 AM", "10:30 AM", "11:00 AM",
            "11:30 AM", "1:30 PM", "2:00 PM",
            "2:30 PM", "3:00 PM", "3:30 AM",
            "4:00 PM", "4:30 PM", "5:00 AM"
    };

    @FXML
    private TableView<RegistroCitas> tableViewCita;
    @FXML
    private TableColumn<RegistroCitas, String> colID;
    @FXML
    private TableColumn<RegistroCitas, String> colIdentidad;
    @FXML
    private TableColumn<RegistroCitas, String> colNombres;
    @FXML
    private TableColumn<RegistroCitas, String> colApellidos;
    @FXML
    private TableColumn<RegistroCitas, String> colFecha;
    @FXML
    private TableColumn<RegistroCitas, String> colHora;

    private ObservableList<RegistroCitas> listaCitas;
    private String dato;

    @FXML
    private TextField busqueda;

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
        listaCitas = FXCollections.observableArrayList();
        listaCitas =  RegistroCitas.llenarTableView(listaCitas);
        tableViewCita.setItems(listaCitas);
        columnasTableViewUsuarios();
    }

    public void actualizarTable(){
        listaCitas = FXCollections.observableArrayList();
        vacio = listaCitas.toString()  ;
        tableViewCita.setItems(listaCitas);
        columnasTableViewUsuarios();
    }

    public void buscarPorNombreOIdentidad(){
        listaCitas = FXCollections.observableArrayList();
        listaCitas =  RegistroCitas.buscarIDYNombre(listaCitas,dato);
        tableViewCita.setItems(listaCitas);
        columnasTableViewUsuarios();
    }


    private void columnasTableViewUsuarios() {
        colID.setCellValueFactory(new PropertyValueFactory<>("id_citas"));
        colIdentidad.setCellValueFactory(new PropertyValueFactory<>("identidad"));
        colNombres.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("dia"));
        colHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        cambioNumeroPorHora();
    }

    private void cambioNumeroPorHora(){
        int x = tableViewCita.getItems().size();
        int indice;
        for (int i=0; i<x; i++){
            indice=(Integer.valueOf(tableViewCita.getItems().get(i).getHora()));;
            tableViewCita.getItems().get(i).setHora(CAMPOS_VALIDOS[indice]);
        }
    }

    public void obtenerIdCita(MouseEvent mouseEvent) {
        try {
        id_cita = tableViewCita.getSelectionModel().getSelectedItem().getId_citas();
        MisFunciones.setId_citas(id_cita);
        }catch (NullPointerException e){
            mensaje("Seleccione un campo, no seleccione campos vacios");
        }
    }

    public void abrirFormulario() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("registroCita.fxml"));
        Stage sStage = new Stage();
        sStage.setTitle("Med Notes");
        sStage.setScene(new Scene(root, 400, 475));
        sStage.show();
    }

    public void abrirFormularioNuevo(ActionEvent actionEvent) {
        try{
            MisFunciones.setId_citas(0);
            abrirFormulario();
        }catch (Exception e){

        }
    }

    public void abrirFormularioEditar(ActionEvent actionEvent) {
        if (MisFunciones.getId_citas()==0){
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

    public void cambioTexto(InputMethodEvent inputMethodEvent) {

    }

    public void eliminar(ActionEvent actionEvent) {
        if (MisFunciones.getId_citas()==0){
            mensaje("No ha seleccionado ninguna cita");

        }else{
            Alert aler = new Alert(Alert.AlertType.CONFIRMATION, "Eliminar esta cita? ", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            aler.showAndWait();
            if(aler.getResult() == ButtonType.YES){
                if (RegistroCitas.eliminarCita()){
                    actualizarTable();
                    actualizarTableViewLista();
                    mensaje("Registro borrado");
                } else{
                    mensaje("No se borro, hubo problemas");
                }
            }
        }

    }

    public void actualizacion(ActionEvent actionEvent) {
    actualizarTable();
    actualizarTableViewLista();
    }
}
