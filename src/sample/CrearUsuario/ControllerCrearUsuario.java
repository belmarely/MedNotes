package sample.CrearUsuario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Stage;
import sample.libs.Conexion;
import sample.modelos.FuncionesOrganicasGenerales;
import sample.modelos.MisFunciones;
import sample.modelos.Usuario;
import sample.modelos.UsuarioIniciarSesion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerCrearUsuario {

    private String nombreUsuario;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCorreo;

    @FXML
    private PasswordField txtClave;

    @FXML
    private TextField txtConfirmarPalabraClave;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnCrear;

    @FXML
    private Label lblClave;

    public void btnCancelar() {

        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }


    public void BotonGuardarActualizar(ActionEvent actionEvent){

        if (MisFunciones.getIdUsuario()!=0) {
            Actualizar();
        } else{
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

    private String llenarNombreUser() {
        if (MisFunciones.getIdUsuario() == MisFunciones.getIdUsuario()){

            Usuario editarUsuario = crearIntancia();
            nombreUsuario = editarUsuario.getNombre_usuario();

        }return nombreUsuario;
    }



    private boolean comprobarCamposVacios(){

        if (!txtNombre.getText().isEmpty() &&
                !txtApellido.getText().isEmpty() &&
                !txtCorreo.getText().isBlank() &&
                !txtClave.getText().isBlank()&&
                !txtConfirmarPalabraClave.getText().isBlank() && (txtClave.getText().equals(txtConfirmarPalabraClave.getText())) && validarMayor8())
        {
            mensaje("Su nombre de usuario es: "+ llenarNombreUser());

        } else {
            mensaje("Las Contraseñas no son iguales");
        }
        {
            return true;
        }
    }



    public Usuario crearIntancia(){
        try {

            Usuario crearUsuario = new
                    Usuario(txtNombre.getText(), txtApellido.getText(),
                    txtCorreo.getText(),
                    txtClave.getText());
            return crearUsuario;

        }catch (Exception e){
            mensaje("Arregle el correo");
        }

        return crearIntancia();

    }

    public void Guardar() {
        if (comprobarCamposVacios()) {
            Usuario crearUser = crearIntancia();
            Usuario.Guardar(crearUser);
            mensaje("Datos guardados exitosamente");
            btnCancelar();

        }else{
            mensaje("Campos Vacios");
        }

    }

    public void cerrar(ActionEvent actionEvent) {


        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();


    }

    private void mensaje(String mensaje){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


    public boolean validarMayor8() {
        if(txtClave.getLength()>=8){
            return(true);
        }else{
            mensaje("Su contraseña debe tener mas de 7 caracteres");
            txtClave.setText("");
            txtConfirmarPalabraClave.setText("");
            return (false);
        }
    }
}
