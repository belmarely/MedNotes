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

    public void login(ActionEvent actionEvent) {

        try
        {
            Stage planillaStage=new Stage();
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("RegistroCita/registroCita.fxml"));
            Scene scene = new Scene(root,560,390);
            planillaStage.setScene(scene);
            planillaStage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void crearUsuario(ActionEvent actionEvent) {

        try
        {
            Stage planillaStage=new Stage();
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("CrearUsuario/crearUsuario.fxml"));
            Scene scene = new Scene(root,560,390);
            planillaStage.setScene(scene);
            planillaStage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }





}
