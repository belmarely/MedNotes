package sample.modelos;

public class MisFunciones {
    private static int idUsuario;
    private static int idPaciente;
    private static int idExamenFisico ;
    private static int id_citas;

    public static int getId_citas() {
        return MisFunciones.id_citas;
    }

    public static void setId_citas(int id_citas) {
        MisFunciones.id_citas = id_citas;
    }

    public static int getIdExamenFisico() {
        return MisFunciones.idExamenFisico;
    }

    public static void setIdExamenFisico(int idExamenFisico) {
        MisFunciones.idExamenFisico = idExamenFisico;
    }

    public static int getIdUsuario() {
        return MisFunciones.idUsuario;
    }

    public static void setIdUsuario(int idUsuario) {
        MisFunciones.idUsuario = idUsuario;
    }

    public static int getIdPaciente() {
        return idPaciente;
    }

    public static void setIdPaciente(int idPaciente) {
        MisFunciones.idPaciente = idPaciente;
    }
}
