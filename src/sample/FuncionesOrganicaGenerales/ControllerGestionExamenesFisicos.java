package sample.FuncionesOrganicaGenerales;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.modelos.FuncionesOrganicasGenerales;
import sample.modelos.MisFunciones;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerGestionExamenesFisicos implements Initializable {

    //region Variables de traidas de Scene Builder
    //Para llenar el tableView
    private int id_examenFisico;
    private int id_paciente;
    @FXML
    private TableView<FuncionesOrganicasGenerales> tableViewExamen;
    @FXML
    private TableColumn<FuncionesOrganicasGenerales, String> colIdentidad;
    @FXML
    private TableColumn<FuncionesOrganicasGenerales, String> colNombres;
    @FXML
    private TableColumn<FuncionesOrganicasGenerales, String> colApellidos;
    @FXML
    private TableColumn<FuncionesOrganicasGenerales, String> colcreacion;
    @FXML
    private TableColumn<FuncionesOrganicasGenerales, String> colID;
    @FXML
    private VBox VBoxFormularioNuevoExamen;
    //Para el registro de empleados
    @FXML
    private Button btnNuevoExamen;
    @FXML
    private Label lblNuevoExamen;
    @FXML
    private TextField txtCampoBusqueda;


    //endregion

    //region Variable Locales
    private ObservableList<FuncionesOrganicasGenerales> listaExamen;

    //endregion

    //  @FXML
    // public void initialize() {
    //tableViewEmpleado.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    // }

    private void actualizarTableViewExamen(){
        listaExamen = FXCollections.observableArrayList();
        listaExamen =  FuncionesOrganicasGenerales.llenarTableView(listaExamen);
        tableViewExamen.setItems(listaExamen);
        columnasTableViewUsuarios();
    }


    /**Busqueda parcial del usuario ingresado */
    public void onBuscarCampoUsuarioKeyTyped(KeyEvent event) {
        //listaExamen = FXCollections.observableArrayList();
        //Usuario.datosDeUsuarioBuscado(listaExamen, txtCampoBusqueda.getText().trim());
        //tableViewEmpleado.setItems(listaExamen);
        //columnasTableViewUsuarios();
    }

    private void columnasTableViewUsuarios() {
        colID.setCellValueFactory(new PropertyValueFactory<>("id_examen_fisico"));
        colIdentidad.setCellValueFactory(new PropertyValueFactory<>("identidad"));
        colNombres.setCellValueFactory(new PropertyValueFactory<>("nombresPaciente"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidosPaciente"));
        colcreacion.setCellValueFactory(new PropertyValueFactory<>("creacionExamen"));
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        actualizarTableViewExamen();

    }

    public void obtenerIdExamen(MouseEvent mouseEvent) {
        id_examenFisico = Integer.parseInt(tableViewExamen.getSelectionModel().getSelectedItem().getId_examen_fisico());
        MisFunciones.setIdExamenFisico(id_examenFisico);
        id_paciente = Integer.parseInt(tableViewExamen.getSelectionModel().getSelectedItem().getId_paciente());
        MisFunciones.setIdPaciente(id_paciente);
        System.out.println(" examen  " + MisFunciones.getIdExamenFisico());
        System.out.println(" paciente " + MisFunciones.getIdPaciente());
    }


    public void abrirFormulario() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("funcionesOrganicasGenerales.fxml"));
        Stage sStage = new Stage();
        sStage.setTitle("Med Notes");
        sStage.setScene(new Scene(root, 400, 475));
        sStage.show();
    }

    public void abrirFormularioNuevo(ActionEvent actionEvent) {
        try{
            MisFunciones.setIdExamenFisico(0);
            abrirFormulario();
        }catch (Exception e){

        }
    }
    public void abrirFormularioEditar(ActionEvent actionEvent) {
        if (MisFunciones.getIdExamenFisico()==0){
            mensaje("No ha seleccionado ningun examen fisico");
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
}
