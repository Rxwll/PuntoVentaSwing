import javax.swing.*;
import java.awt.*;


public class LoginPane extends JPanel{
    private JTextField usernameField;
    private JPasswordField passwordField;
    JButton LoginButton;
    JButton goToRegisterButton;

    CardLayout cardLayout;
    JPanel cards;
    public LoginPane(CardLayout cardLayout, JPanel cards) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        this.usernameField = new JTextField(10);
        this.passwordField = new JPasswordField(10);
        this.LoginButton = new JButton("Iniciar sesion");
        this.goToRegisterButton = new JButton("Registrarse");

        gbc.gridwidth= GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2,10,10,10);

        add(new JLabel("Usuario"), gbc);
        add(usernameField, gbc);
        add(new JLabel("Contraseña"), gbc);
        add(passwordField, gbc);

        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        add(LoginButton, gbc);
        add(goToRegisterButton, gbc);
    }
}
