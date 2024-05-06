import javax.swing.*;
import java.awt.*;


public class LoginPane extends JPanel{
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    JButton LoginButton;
    JButton goToRegisterButton;

    public LoginPane(CardLayout cardLayout, JPanel cards) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        this.usernameField = new JTextField(20);
        this.passwordField = new JPasswordField(20);
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
        LoginButton.addActionListener(e -> {
            Login login = new Login(usernameField.getText(),passwordField.getText());
            if(login.isUserValid()){
                cardLayout.show(cards, "Productos");
            }else{
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            }
        });
        add(goToRegisterButton, gbc);
        goToRegisterButton.addActionListener(e -> {
            cardLayout.show(cards, "register");
        });
    }
}
