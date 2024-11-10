package src.Modelo.DAO;
import src.Controlador.Main;
import src.Modelo.Excursiones;
import src.Modelo.Excursiones;
import java.sql.*;
import java.util.ArrayList;

    public class ExcursionesDAO {
        public ArrayList<Excursiones> listarExcursiones() {
            ArrayList<Excursiones> excursiones = new ArrayList<>();
            String consultaSQL = "SELECT codExcursion, descripcion, fecha, numDias, precioInscripcion FROM excursiones";

            try (Connection conexion = Main.ConectarBD();
                 PreparedStatement sentencia = conexion.prepareStatement(consultaSQL);
                 ResultSet resultado = sentencia.executeQuery()) {

                while (resultado.next()) {
                    String codExcursion = resultado.getString("codExcursion");
                    String descripcion = resultado.getString("descripcion");
                    Date fecha = resultado.getDate("fecha");
                    int numDias = resultado.getInt("numDias");
                    float precioInscripcion = resultado.getFloat("precioInscripcion");

                    Excursiones excursion = new Excursiones(codExcursion, descripcion, fecha, numDias, precioInscripcion);
                    excursiones.add(excursion);
                }

            } catch (SQLException e) {
                System.err.println("Error al listar excursiones: " + e.getMessage());
            }
            return excursiones;
        }

        public boolean agregarExcursion(Excursiones excursion) {
            String consultaSQL = "INSERT INTO excursiones (codExcursion, descripcion, fecha, numDias, precioInscripcion) VALUES (?, ?, ?, ?, ?)";

            try (Connection conexion = Main.ConectarBD();
                 PreparedStatement sentencia = conexion.prepareStatement(consultaSQL)) {

                sentencia.setString(1, excursion.getCodExcursion());
                sentencia.setString(2, excursion.getDescripcion());
                sentencia.setDate(3, new java.sql.Date(excursion.getFecha().getTime()));
                sentencia.setInt(4, excursion.getNumDias());
                sentencia.setFloat(5, excursion.getPrecioInscripcion());

                return sentencia.executeUpdate() > 0;

            } catch (SQLException e) {
                System.err.println("Error al agregar excursión: " + e.getMessage());
                return false;
            }
        }
    }

