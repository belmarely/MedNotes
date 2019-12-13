package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    private double x, y;
    @FXML
    private Button btnInicio;

    @FXML
    private Button btnCrearCuenta;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Diagnosticos/diagnosticos.fxml"));
        primaryStage.setTitle("Med Notes");
        primaryStage.setScene(new Scene(root));
        //set stage borderless
      //  primaryStage.initStyle(StageStyle.UNDECORATED);

        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);

        });

        primaryStage.show();
    }

    public void handleClicks(ActionEvent actionEvent){
        if (actionEvent.getSource() == btnInicio) {
            btnInicio.setVisible(true);
        }
        if (actionEvent.getSource() == btnCrearCuenta) {
            btnCrearCuenta.setVisible(true);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
