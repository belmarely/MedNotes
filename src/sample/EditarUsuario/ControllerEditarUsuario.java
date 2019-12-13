package sample.EditarUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.libs.Conexion;
import sample.modelos.FuncionesOrganicasGenerales;
import sample.modelos.MisFunciones;
import sample.modelos.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.awt.*;

public class ControllerEditarUsuario {

    @FXML
    private TextField txtNombre;

    @FXML
    private  TextField txtApellido;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtClave;

    @FXML 
    private TextField txtConfirmarClave;
    
    @FXML
    private Button btnCancelar;
    
    @FXML
    private Button btnGuardar;

    @FXML
    private TextField nombreUser;

    @FXML
    private void initialize() {
        llenarCampos();
    }

    private boolean llenarCampos() {
        if (MisFunciones.getIdUsuario() == MisFunciones.getIdUsuario()){
            Usuario editarUsuario = crearInstancia();
            nombreUser.setText(editarUsuario.getNombre_usuario());
            txtNombre.setText(editarUsuario.getNombre());
            txtApellido.setText(editarUsuario.getApellido());
            txtCorreo.setText(editarUsuario.getCorreo_electronico());
            txtClave.setText(editarUsuario.getClave());
            
        }return true;
    }

    public void cerrar(ActionEvent actionEvent) {


        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();


    }


    public Usuario crearInstancia(){
        Usuario crearUsuario = new
                Usuario(txtNombre.getText(),txtApellido.getText(),
                txtCorreo.getText(),
                txtClave.getText());
        return crearUsuario;

    }
    
    public void Guardar() {
        if (llenarCampos()) {
            Usuario crearUser = crearInstancia();
            Usuario.Guardar(crearUser);
            mensaje("Datos guardados exitosamente");
            btnCancelar();

        }else{
            mensaje("Campos Vacios");
        }

    }

    public void BotonGuardarActualizar(ActionEvent actionEvent){

        if (MisFunciones.getIdUsuario()!=0) {
            Actualizar();
        } else if(validarMayor8()){
            Guardar();
        }
    }

    public void btnCancelar() {

        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }


    private void Actualizar() {

        if (llenarCampos()) {
            Usuario crearUsuario = crearInstancia();
            Usuario.Actualizar(crearUsuario);
            mensaje("Datos Actualizados exitosamente");
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

    public boolean validarMayor8() {
        if(txtClave.getLength()>=8){
            return(true);
        }else{
            mensaje("Su contraseña debe tener mas de 7 caracteres");
            txtClave.setText("");
            txtConfirmarClave.setText("");
            return (false);
        }
    }

}
