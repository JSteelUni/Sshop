package View;

import Model.ItemTemplate;

import javax.swing.*;

public class ProductDetailsView extends JFrame {

    private ItemTemplate item;

    // creates page to see products and all attributes
    public ProductDetailsView(ItemTemplate item) {
        this.item = item;

        setTitle(item.name);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel nameLabel = new JLabel(item.name, SwingConstants.CENTER);
        JLabel priceLabel = new JLabel("£" + item.price, SwingConstants.CENTER);
        JLabel imageLabel = new JLabel("IMAGE", SwingConstants.CENTER);

        // orientates panel components
        add(nameLabel, "North");
        add(imageLabel, "Center");
        add(priceLabel, "South");

        setVisible(true);
    }
}