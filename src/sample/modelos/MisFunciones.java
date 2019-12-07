package sample.modelos;

public class MisFunciones {
    private static int idUsuario;
    private static int idPaciente = 1;
    private static int idExamenFisico = 3;

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
        idUsuario = idUsuario;
    }

    public static int getIdPaciente() {
        return idPaciente;
    }

    public static void setIdPaciente(int idPaciente) {
        idPaciente = idPaciente;
    }
}
