package sample.modelos;

public class MisFunciones {
    private static int idUsuario;
    private static int idPaciente  ;
    private static int idExamenFisico ;

    public static int getIdExamenFisico() {
        return idExamenFisico;
    }

    public static void setIdExamenFisico(int idExamenFisico) {
        MisFunciones.idExamenFisico = idExamenFisico;
    }

    public static int getIdUsuario() {
        return idUsuario;
    }

    public static void setIdUsuario(int idUsuario) {
        MisFunciones.idUsuario   = idUsuario;
    }

    public static int getIdPaciente() {
        return idPaciente;
    }

    public static void setIdPaciente(int idPaciente) {
        MisFunciones.idPaciente = idPaciente;
    }
}
