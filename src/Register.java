import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Register implements Runnable{
    String username;
    String email;
    String contra;

    public Register(String username, String email,String contra) {
        this.username = username;
        this.email = email;
        this.contra = contra;
    }

    @Override
    public void run() {
        try {
            Connection connection = Singleton.getInstance().getConnection();
            PreparedStatement stm = connection.prepareStatement("INSERT INTO Usuarios(UsuarioID, Nombre, Email,Contra) VALUES (?, ?, ?, ?)");
            stm.setNull(1, java.sql.Types.INTEGER);
            stm.setString(2, username);
            stm.setString(3, email);
            stm.setString(4, contra);
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

