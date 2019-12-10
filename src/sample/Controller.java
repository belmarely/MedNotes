package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller {

    private double x, y;

    public void login(ActionEvent actionEvent) {

        try
        {
            Stage planillaStage=new Stage();
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("InicioSesion/iniciarSesion.fxml"));
            planillaStage.setScene(new Scene(root));
            planillaStage.initStyle(StageStyle.UNDECORATED);

            //drag it here
            root.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
            root.setOnMouseDragged(event -> {

                planillaStage.setX(event.getScreenX() - x);
                planillaStage.setY(event.getScreenY() - y);

            });
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
            planillaStage.setScene(new Scene(root));
            planillaStage.initStyle(StageStyle.UNDECORATED);

            //drag it here
            root.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
            root.setOnMouseDragged(event -> {

                planillaStage.setX(event.getScreenX() - x);
                planillaStage.setY(event.getScreenY() - y);

            });
            planillaStage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }





}
