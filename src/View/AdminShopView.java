package View;

import javax.swing.*;
import java.awt.*;

public class AdminShopView extends JFrame {

    public JPanel itemGrid;
    public JButton addButton, logoutButton;

    public AdminShopView() {

        // Title and shop parameters
        setTitle("Admin Shop");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // button parameters
        addButton = new JButton("Add Item");
        addButton.setBounds(20, 20, 120, 30);
        add(addButton);

        // logout button parameters
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(160, 20, 120, 30);
        add(logoutButton);

        // grid parameters and panels
        itemGrid = new JPanel();
        itemGrid.setLayout(new GridLayout(0, 4, 10, 10)); // 4 columns
        itemGrid.setBounds(20, 80, 840, 460);

        JScrollPane scrollPane = new JScrollPane(itemGrid);
        scrollPane.setBounds(20, 80, 840, 460);

        add(scrollPane);

        setVisible(true);
    }
}