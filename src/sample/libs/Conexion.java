package sample.libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection con;

    private Conexion() {}

    public static Connection abrirConexion() {

        if (con == null) {

            try {

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registro_medico?useTimezone=true&serverTimezone=UTC", "root", "");

            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }

        }
        return con;
    }



}



