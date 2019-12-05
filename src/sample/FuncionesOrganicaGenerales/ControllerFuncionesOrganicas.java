package sample.FuncionesOrganicaGenerales;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;


public class ControllerFuncionesOrganicas {

    @FXML
    private RadioButton sueno1;
    @FXML
    private RadioButton sueno2;
    @FXML
    private RadioButton sueno3;
    @FXML
    private RadioButton defecacion1;
    @FXML
    private RadioButton defecacion2;
    @FXML
    private RadioButton defecacion3;
    @FXML
    private RadioButton miccion1;
    @FXML
    private RadioButton miccion2;
    @FXML
    private RadioButton miccion3;
    @FXML
    private RadioButton sed1;
    @FXML
    private RadioButton sed2;
    @FXML
    private RadioButton sed3;
    @FXML
    private RadioButton apetito1;
    @FXML
    private RadioButton apetito2;
    @FXML
    private RadioButton apetito3;
    @FXML


    private void initialize() {
        relacionesRadioBotones();
    }

    private void relacionesRadioBotones(){
        ToggleGroup agrupacion1 = new ToggleGroup();
        apetito1.setToggleGroup(agrupacion1);
        apetito2.setToggleGroup(agrupacion1);
        apetito3.setToggleGroup(agrupacion1);
        ToggleGroup agrupacion2 = new ToggleGroup();
        sed1.setToggleGroup(agrupacion2);
        sed2.setToggleGroup(agrupacion2);
        sed3.setToggleGroup(agrupacion2);
        ToggleGroup agrupacion3 = new ToggleGroup();
        miccion1.setToggleGroup(agrupacion3);
        miccion2.setToggleGroup(agrupacion3);
        miccion3.setToggleGroup(agrupacion3);
        ToggleGroup agrupacion4 = new ToggleGroup();
        defecacion1.setToggleGroup(agrupacion4);
        defecacion2.setToggleGroup(agrupacion4);
        defecacion3.setToggleGroup(agrupacion4);
        ToggleGroup agrupacion5 = new ToggleGroup();
        sueno1.setToggleGroup(agrupacion5);
        sueno2.setToggleGroup(agrupacion5);
        sueno3.setToggleGroup(agrupacion5);
    }

}