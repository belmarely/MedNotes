package sample.modelos;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import sample.libs.Conexion;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Diagnosticos {

    private String idPaciente;
    private String diagnostico;
    private String creacion;
    private String nombres;

    public static void BuscarPorNombre(ObservableList<Diagnosticos> listaDiagnostico, String dato) {
        try{
            PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement("SELECT expedientes.nombres, diagnostico, diagnosticos.creacion FROM diagnosticos" +
                    " INNER JOIN expedientes ON expedientes.id_expediente = diagnosticos.id_paciente where nombres like ? ;");
            sentencia.setString(1,dato + "%");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()){
                listaDiagnostico.add(Diagnosticos.crearInstancia(resultado));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public static void llenarTableView(ObservableList<Diagnosticos> listaDiagnostico) {
        try{
            PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement("SELECT expedientes.nombres, diagnostico, diagnosticos.creacion FROM diagnosticos" +
                    " INNER JOIN expedientes ON expedientes.id_expediente = diagnosticos.id_paciente ;");
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()){
                listaDiagnostico.add(Diagnosticos.crearInstancia(resultado));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Diagnosticos crearInstancia (ResultSet resultado){
        try{
            Diagnosticos diagnosticos= new Diagnosticos(resultado.getString("expedientes.nombres"),
                    resultado.getString("diagnostico"),
                    resultado.getString("creacion"),
                    resultado.getString("nombres"));
            return diagnosticos;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static boolean Agregar(String crearDiagnostico){

        try{
            PreparedStatement sentencia = Conexion.abrirConexion().prepareStatement(
                    "INSERT INTO `registro_medico`.`diagnosticos` (`diagnostico`) \n" +
                            "VALUES ?;"
            );

            sentencia.setString(1, crearDiagnostico);

            boolean resultado=  sentencia.execute();

            return resultado;

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return false;
    }

    public Diagnosticos(String idPaciente, String diagnostico, String creacion, String nombres) {
        this.idPaciente = idPaciente;
        this.diagnostico = diagnostico;
        this.creacion = creacion;
        this.nombres = nombres;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getCreacion() {
        return creacion;
    }

    public void setCreacion(String creacion) {
        this.creacion = creacion;
    }



}
