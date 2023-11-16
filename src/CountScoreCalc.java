import javax.swing.*;
import java.awt.*;

public class CountScoreCalc extends JFrame {

    private JPanel panel = new JPanel();

    public CountScoreCalc() {
        super("Score calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(400, 500);
        //this.setLocation(200, 100);

        CardsProcessing cardsProcessing = new CardsProcessing();
        JButton bring = new JButton("Взять карту");
        JButton pass = new JButton("Пасс");

        panel.setLayout(new BorderLayout());
        panel.add(cardsProcessing, BorderLayout.NORTH);
        panel.add(bring, BorderLayout.WEST);
        panel.add(pass, BorderLayout.EAST);

        this.add(panel, BorderLayout.CENTER);

        bring.addActionListener(new ActionListenerForBring(cardsProcessing));
        pass.addActionListener(new ActionListenerForPass(cardsProcessing));
    }
}
