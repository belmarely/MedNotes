package sample.Home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private VBox pnItems = null;
    @FXML
    private Button btnExpedientes;

    @FXML
    private Button btnCitas;

    @FXML
    private Button btnDiagnosticos;

    @FXML
    private Button btnUsuarios;


    @FXML
    private Button btnSignout;

    @FXML
    private Pane pnlDiagnosticos;

    @FXML
    private Pane pnlCitas;

    @FXML
    private Pane pnlExpedientes;

    @FXML
    private Pane pnlUsuarios;

    @FXML
    private Button btnMenuDesplegable;

    @FXML
    private  VBox vboxMenuLat;

    @FXML
    private Button btnMedNotes;

    @FXML
    private ImageView btnImgMedNotes;


    public void onOcultarMenuClicked(MouseEvent event){

        if(btnMedNotes.getText().equals("")){
            vboxMenuLat.setPrefWidth(257);
            btnMedNotes.setText("MedNotes");
            btnImgMedNotes.setFitWidth(143);
            btnImgMedNotes.setFitHeight(107);

        } else {
            vboxMenuLat.setPrefWidth(45);
            btnMedNotes.setText("");
            btnImgMedNotes.setFitWidth(40);
            btnImgMedNotes.setFitHeight(40);
        }
    }

    public void onExitButtonClicked(MouseEvent event) {
        Stage stage = (Stage) btnSignout.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnDiagnosticos) {
            pnlDiagnosticos.setStyle("-fx-background-color :  #348F87");
            pnlDiagnosticos.toFront();
        }
        if (actionEvent.getSource() == btnUsuarios) {
            pnlUsuarios.setStyle("-fx-background-color : #53639F");
            pnlUsuarios.toFront();
        }
        if (actionEvent.getSource() == btnExpedientes) {
            pnlExpedientes.setStyle("-fx-background-color : #272935");
            pnlExpedientes.toFront();
        }
        if(actionEvent.getSource()== btnCitas)
        {
            pnlCitas.setStyle("-fx-background-color : #464F67");
            pnlCitas.toFront();
        }
    }

    public void BotonInvisible(ActionEvent actionEvent) {
        if (btnImgMedNotes.isVisible()){
            btnImgMedNotes.setVisible(false);
            vboxMenuLat.setPrefWidth(257);
            btnMedNotes.setText("MedNotes");
        } else {
            btnImgMedNotes.isVisible();
            btnImgMedNotes.setVisible(true);
            vboxMenuLat.setPrefWidth(45);
        }

    }
}


