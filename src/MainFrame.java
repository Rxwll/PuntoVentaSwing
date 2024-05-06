import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout =new CardLayout();

    private JPanel cards = new JPanel(cardLayout);


    MainFrame(){
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeUI();
    }

    public void initializeUI(){
        RegisterPane registerPane = new RegisterPane(cardLayout, cards);
        LoginPane loginPane = new LoginPane(cardLayout,cards);
        TablePane tablePane = new TablePane(cardLayout,cards);

        cards.add(loginPane, "login");
        cards.add(registerPane, "register");
        cards.add(tablePane, "Productos");

        add(cards);
    }
}
