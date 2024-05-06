import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Register implements Runnable{
    String username;
    String password;
    JButton registerButton;
    JButton goToLoginButton;

    public Register(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void run() {
        try {
            Connection connection = Singleton.getInstance().getConnection();
            PreparedStatement stm = connection.prepareStatement("INSERT INTO Usuarios(UsuarioID, Nombre, Password) VALUES (?, ?, ?)");
            stm.setInt(1, 0);
            stm.setString(2, username);
            stm.setString(3, password);
            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

