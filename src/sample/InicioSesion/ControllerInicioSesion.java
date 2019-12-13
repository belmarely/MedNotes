package sample.InicioSesion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.modelos.Usuario;
import sample.modelos.UsuarioIniciarSesion;


public class ControllerInicioSesion {
    @FXML
    private  Button btnLogin;

    @FXML
    private  Button enviar;

    @FXML
    private TextField txtNombre_Usuario;

    @FXML
    private PasswordField txtPalabraClave;


    private void btnLogin(){
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        stage.close();
    }

    public UsuarioIniciarSesion crearInstancia() {
        UsuarioIniciarSesion inicioSesion = new
                UsuarioIniciarSesion(txtNombre_Usuario.getText(),
                txtPalabraClave.getText());
        return inicioSesion;

    }


    public void comprobarCampos() {
        String usuario = txtNombre_Usuario.getText().toString();
        String contrasena = txtPalabraClave.getText().toString();
        if (!txtNombre_Usuario.getText().isEmpty() &&
                !txtPalabraClave.getText().isBlank()){
            if (UsuarioIniciarSesion.comprobandoUsario(usuario,contrasena)) {
                try
                {
                    Stage planillaStage=new Stage();
                    AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("../Home/Home.fxml"));
                    Scene scene = new Scene(root,1050,576);
                    planillaStage.setScene(scene);
                    planillaStage.show();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            } else {
                mensaje("Usario y/o contraseña incorrectos");
            }
    }else{
            mensaje("Usario y/o contraseña vacios");
        }

    }


    private void mensaje(String mensaje) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


    public void home(ActionEvent actionEvent) {
        comprobarCampos();

    }

}
