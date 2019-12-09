package sample.Home;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControllerHome {

    private double x, y;

    public void home(ActionEvent actionEvent) {

        try
        {
            Stage planillaStage=new Stage();
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Home/Home.fxml"));
            Scene scene = new Scene(root,560,390);
            planillaStage.setScene(scene);

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
