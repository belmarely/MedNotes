package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.modelos.FuncionesOrganicasGenerales;

import java.io.IOException;


public class Controller {
    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField contraseña;

    @FXML

    public void login(ActionEvent actionEvent) {

        try
        {
            Stage planillaStage=new Stage();
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("InicioSesion/iniciarSesion.fxml"));
            Scene scene = new Scene(root,360,290);
            planillaStage.setScene(scene);
            planillaStage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }


}
