package View;
import javax.swing.*;
import java.awt.*;

public class ItemPanelView extends JPanel {

    public JLabel itemImageLabel;
    public JLabel itemNameLabel;
    public JLabel priceLabel;

    // creates the item panel layout for users
    public ItemPanelView(String name, double price) {

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(120, 150));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // default image
        itemImageLabel = new JLabel("IMG", SwingConstants.CENTER);
        itemImageLabel.setPreferredSize(new Dimension(120, 90));
        itemImageLabel.setOpaque(true);
        itemImageLabel.setBackground(new Color(220, 220, 220));

        itemNameLabel = new JLabel(name, SwingConstants.CENTER);
        priceLabel = new JLabel("€" + price, SwingConstants.CENTER);

        // orientates panel components
        add(itemImageLabel, BorderLayout.NORTH);
        add(itemNameLabel, BorderLayout.CENTER);
        add(priceLabel, BorderLayout.SOUTH);

        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}