package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.modelos.FuncionesOrganicasGenerales;

import java.io.IOException;

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

    public void ExamenFisico(ActionEvent actionEvent) throws IOException {
        try
        {
            Stage planillaStage =new Stage();
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("FuncionesOrganicaGenerales/funcionesOrganicasGenerales.fxml"));
            Scene scene = new Scene(root,1000,700);
            planillaStage.setScene(scene);
            planillaStage.show();

        }
        catch(Exception e)
        {

        }
    }

    public void ver(ActionEvent actionEvent) {
       try {

            Stage planillaStage =new Stage();
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("RegistroCita/registroCita.fxml"));
            Scene scene = new Scene(root,1000,700);
            planillaStage.setScene(scene);
            planillaStage.show();

        }
        catch(Exception e)
        {

        }
    }

    public void BotonGuardarActualizar(ActionEvent actionEvent) {
    }
}
