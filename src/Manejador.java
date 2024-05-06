import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Manejador {
    public Manejador(){
    }

    public void AgregarCarrito(int id, int cantidad){
    }
    public void insertarProducto(int id, String nombre, int cantidad, double precio){
        Connection conn = Singleton.getInstance().getConnection();
        PreparedStatement stm = null;

        try {
            String query = "INSERT INTO Producto (id, nombre, cantidad, precio) VALUES (?, ?, ?, ?)";
            stm = conn.prepareStatement(query);
            stm.setInt(1,id);
            stm.setString(2,nombre);
            stm.setInt(3,cantidad);
            stm.setDouble(4,precio);

            int affectedRows = stm.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Se insertó el registro correctamente.");
            }
            else {
                System.out.println("No se insertó ningún registro.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
