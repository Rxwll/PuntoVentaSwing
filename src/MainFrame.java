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

    public JPanel getCards() {
        return cards;
    }

   public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void initializeUI(){
        RegisterPane registerPane = new RegisterPane(cardLayout, cards);
        LoginPane loginPane = new LoginPane(cardLayout,cards);

        cards.add(registerPane, "register");
        cards.add(loginPane, "login");

        add(cards);
    }
}
