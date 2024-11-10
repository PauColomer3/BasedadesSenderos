package src.Controlador;
import src.Controlador.ControladorSenderos;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
public class Main {
    public static Connection ConectarBD(){
        Connection conexion;
        String host = "jdbc:mysql://127.0.0.1:3306/";
        String user = "root";
        String pass = "admin1234";
        String bd = "senderos";

        System.out.println("Conectando BD...");

        try {
            conexion = DriverManager.getConnection(host+bd,user,pass);
            System.out.println("Conexion Exitosa");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return conexion;
    }
    public static void main(String[] args) {
        Connection bd = ConectarBD();
        ControladorSenderos controlador = new ControladorSenderos();
        controlador.iniciar();
    }
}

