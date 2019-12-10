package sample.CrearUsuario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.libs.Conexion;
import sample.modelos.FuncionesOrganicasGenerales;
import sample.modelos.MisFunciones;
import sample.modelos.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerCrearUsuario {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextArea txtApellid;

    @FXML
    private TextArea txtCorreo;

    @FXML
    private TextField txtPalabraClave;

    @FXML
    private TextField txtConfirmarPalabraClave;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnCrear;

    public void btnCancelar() {

        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }


    public void BotonGuardarActualizar(ActionEvent actionEvent){

        if (MisFunciones.getIdUsuario()!=0) {
            Actualizar();
        } else {
            Guardar();
        }
    }


    private void Actualizar() {

        if (comprobarCamposVacios()) {
            Usuario crearUsuario = crearIntancia();
            Usuario.Actualizar(crearUsuario);
            mensaje("Datos Actualizados exitosamente");
            btnCancelar();

        }else{
            mensaje("Campos Vacios");
        }

    }

    private void comprobarCampos(){

        String confirmarPalabraClave = txtConfirmarPalabraClave.getText();
        if (!txtNombre.getText().isEmpty() &&
                !txtApellid.getText().isEmpty() &&
                !txtCorreo.getText().isEmpty() &&
                !txtPalabraClave.getText().isBlank()){
            if (txtPalabraClave.getText().equals(confirmarPalabraClave)) {
                mensaje("Se creo un nuevo usuario con Éxito");

            } else {
                mensaje("La Contraseña no son iguales");
            }
        }else{
            mensaje("Usario y/o contraseña vacios");
        }
    }




    private boolean comprobarCamposVacios(){

        if (!txtNombre.getText().isEmpty() &&
                !txtApellid.getText().isEmpty() &&
                !txtCorreo.getText().isBlank() &&
                !txtPalabraClave.getText().isBlank() &&
                !txtConfirmarPalabraClave.getText().isBlank())
        {
            return true;
        }
        return false;
    }



    public Usuario crearIntancia(){
        Usuario crearUsuario = new
                Usuario(txtNombre.getText(),txtApellid.getText(),
                txtCorreo.getText(),
                txtPalabraClave.getText());
        return crearUsuario;

    }

    public void Guardar() {

       comprobarCampos();
    }


    private void mensaje(String mensaje){

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


}
