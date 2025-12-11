package View;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    public JTextField usernameField;
    public JPasswordField passwordField;
    public JButton submitButton;
    public JCheckBox registerCheck;

    public LoginView() {

        setTitle("Login / Register");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center window

        // The panel layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 5, 5));

        // Username text-field
        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        // Password text-field
        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        // Checkbox account checkbox
        registerCheck = new JCheckBox("Register new account");
        panel.add(registerCheck);

        // Submit login details (will act as Login or Register)
        submitButton = new JButton("Login");
        panel.add(submitButton);

        // Change button text depending on checkbox
        registerCheck.addActionListener(e -> {
            if (registerCheck.isSelected()) {
                submitButton.setText("Register");
            } else {
                submitButton.setText("Login");
            }
        });

        add(panel);
        setVisible(true);
    }
}