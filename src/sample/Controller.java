package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {
    public void abrir(ActionEvent actionEvent) {

        try
        {
            Stage planillaStage=new Stage();
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("RegistroCita/registroCita.fxml"));
            Scene scene = new Scene(root,360,290);

            planillaStage.setScene(scene);
            planillaStage.show();
        }
        catch(Exception e)
        {

        }
    }
}
