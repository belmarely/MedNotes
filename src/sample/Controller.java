package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class Controller {

    @FXML
    private void initialize() {

    }

    public void abrir(ActionEvent actionEvent) {

        try
        {
            Stage planillaStage=new Stage();
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("funcionesOrganicasGenerales.fxml"));
            Scene scene = new Scene(root,360,290);

            planillaStage.setScene(scene);
            planillaStage.show();
        }
        catch(Exception e)
        {

        }
    }

    public void seleccionApetito(ActionEvent actionEvent) {

    }
}
