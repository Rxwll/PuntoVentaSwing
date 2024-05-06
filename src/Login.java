import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
    String username;
    String password;
    public Login(String username,String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isUserValid(){
        String query = "SELECT * FROM Usuarios WHERE Nombre = ? AND Contra = ?";
        try {
            Connection connection = Singleton.getInstance().getConnection();
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()){
                int userID = rs.getInt("UsuarioID");
                SesionUsuario.createInstance(String.valueOf(userID), username);
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
