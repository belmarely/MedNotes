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


public class Controller {
    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField contraseña;

    @FXML

    public void abrir(ActionEvent actionEvent) {

        try
        {
            Stage planillaStage=new Stage();
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("iniciarSesion.fxml"));
            Scene scene = new Scene(root,360,290);
            planillaStage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
