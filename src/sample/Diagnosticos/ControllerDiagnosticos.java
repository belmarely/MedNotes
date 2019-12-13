package sample.Diagnosticos;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.modelos.Diagnosticos;
import sample.modelos.FuncionesOrganicasGenerales;
import sample.modelos.Usuario;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;


public class ControllerDiagnosticos implements Initializable   {
ObservableList<Diagnosticos> listaDiagnostico;
    @FXML
    private TextField txtDiag;

    private String dato;

    @FXML
    private TableView diagnostico;

    @FXML
    private TableColumn coluPaciente;

    @FXML
    private TableColumn colIdentidad;

    @FXML
    private javafx.scene.control.TableColumn coluDiagnostico;

    @FXML
    private javafx.scene.control.TableColumn colucreacion;

    @FXML
    private TextField busqued;

    public void obtenerId(MouseEvent mouseEvent)
    {

    }
    private void actualizarTableViewDiagnostico(){
        listaDiagnostico = FXCollections.observableArrayList();
        Diagnosticos.llenarTableView(listaDiagnostico);
        diagnostico.setItems(listaDiagnostico);
        columnasTableViewUsuarios();
    }


    private void columnasTableViewUsuarios() {
        coluDiagnostico.setCellValueFactory(new PropertyValueFactory<>("diagnostico"));
        colucreacion.setCellValueFactory(new PropertyValueFactory<>("creacion"));
        colIdentidad.setCellValueFactory(new PropertyValueFactory<>("nombres"));

    }

    private void mensaje(String mensaje){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }




    private void buscarPorNombreOIdentidad() {
        listaDiagnostico = FXCollections.observableArrayList();
        Diagnosticos.BuscarPorNombre(listaDiagnostico,dato);
        diagnostico.setItems(listaDiagnostico);
        columnasTableViewUsuarios();
    }

    public void obtenerId(javafx.scene.input.MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        actualizarTableViewDiagnostico();
        busqued.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String s2) {
                dato= busqued.getText();
                buscarPorNombreOIdentidad();
            }
        });
    }

    public void agregarDiagnostico(ActionEvent actionEvent) {
        try
        {
            Stage planillaStage=new Stage();
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource(""));
            Scene scene = new Scene(root,560,390);
            planillaStage.setScene(scene);
            planillaStage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void guardarDiagnostico(ActionEvent actionEvent) {
        Diagnosticos.Agregar(txtDiag.getText());
        mensaje("Datos guardados exitosamente");
    }
}
