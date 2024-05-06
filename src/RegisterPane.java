import javax.swing.*;
import java.awt.*;

public class RegisterPane extends JPanel{
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    JButton RegisterButton;
    JButton goToLoginButton;
    CardLayout cardLayout;
    JPanel cards;

    public RegisterPane(CardLayout cardLayout, JPanel cards) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        this.usernameField = new JTextField(20);
        this.emailField = new JTextField(20);
        this.passwordField = new JPasswordField(20);
        this.RegisterButton = new JButton("Registrar");
        this.goToLoginButton = new JButton("Ir a iniciar sesion");

        gbc.gridwidth= GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2,10,10,10);


        add(new JLabel("Usuario"), gbc);
        add(usernameField, gbc);
        add(new JLabel("Correo Electronico"), gbc);
        add(emailField, gbc);
        add(new JLabel("Contraseña"), gbc);
        add(passwordField, gbc);

        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        add(RegisterButton, gbc);
        RegisterButton.addActionListener(e -> {
            Register register = new Register(usernameField.getText(),emailField.getText(),passwordField.getText());
            Thread thread = new Thread(register);
            thread.start();
        });
        add(goToLoginButton, gbc);
        goToLoginButton.addActionListener(e -> {
           cardLayout.show(cards, "login");
        });
    }
}
