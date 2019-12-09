package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.libs.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Controller {
    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML

    public void login(ActionEvent actionEvent) {

        try
        {
            Stage planillaStage=new Stage();
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("InicioSesion/iniciarSesion.fxml"));
            Scene scene = new Scene(root,560,390);
            planillaStage.setScene(scene);
            planillaStage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public int validarUsuario(){
         String usuario = txtUsuario.getText();
         String password = txtPassword.getText();
        int resultado=0;
        try {
            PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement(
                    "SELECT * FROM usuarios WHERE nombre_usuario = ? AND palabra_clave = ?;"
            );
            sentencia.setString(1, usuario);
            sentencia.setString(2, password);
            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {
                resultado=1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado ;
    }

}
