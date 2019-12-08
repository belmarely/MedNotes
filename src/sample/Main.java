package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {
    @FXML
    private Button btnInicio;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FuncionesOrganicaGenerales/funcionesOrganicasGenerales.fxml"));
        primaryStage.setTitle("Med Notes");
        primaryStage.setScene(new Scene(root, 400, 475));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
