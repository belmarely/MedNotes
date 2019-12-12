package sample.Home;

import javafx.application.Platform;
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
    private Pane pnlCustomer;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Pane pnlMenus;

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
            btnImgMedNotes.setFitWidth(98);
            btnImgMedNotes.setFitHeight(101);

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
        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("Item.fxml"));

                //give the items some effect

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #348F87");
                });
                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnDiagnosticos) {
            pnlCustomer.setStyle("-fx-background-color :  #348F87");
            pnlCustomer.toFront();
        }
        if (actionEvent.getSource() == btnUsuarios) {
            pnlMenus.setStyle("-fx-background-color : #53639F");
            pnlMenus.toFront();
        }
        if (actionEvent.getSource() == btnExpedientes) {
            pnlOverview.setStyle("-fx-background-color : #348F87");
            pnlOverview.toFront();
        }
        if(actionEvent.getSource()== btnCitas)
        {
            pnlOrders.setStyle("-fx-background-color : #464F67");
            pnlOrders.toFront();
        }
    }
}


