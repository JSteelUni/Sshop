package Controller;

import Model.UserLogin;
import View.LoginView;

import javax.swing.*;

public class LogInController {

    private LoginView view;

    public LogInController(LoginView view) {
        this.view = view;

        // When the button is clicked, decide whether to login or register
        view.submitButton.addActionListener(e -> handleSubmit());
    }


    private void handleSubmit() {
        // finds the username and password text
        String username = view.usernameField.getText();
        String password = String.valueOf(view.passwordField.getPassword());

        // Check if username and password has values
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please enter a username and password");
            return;
        }

        // Check if the register checkbox is selected to see if user is making a new account or accessing one that exists already
        if (view.registerCheck.isSelected()) {
            //  create new account
            handleRegister(username, password);
        } else {
            // log in to existing
            handleLogin(username, password);
        }
    }

    // gives the user feedback depending if the account was created or not
    private void handleRegister(String username, String password) {
        boolean success = UserLogin.registerUser(username, password);

        if (success) {
            JOptionPane.showMessageDialog(view, "Account created");
        } else {
            JOptionPane.showMessageDialog(view, "Username already exists.");
        }
    }

    // checks the user login and opens the shop if valid, otherwise give an error message
    private void handleLogin(String username, String password) {
        boolean valid = UserLogin.validateLogin(username, password);

        if (valid) {
            JOptionPane.showMessageDialog(view, "Login successful");

            //TODO need the shop to open after login

        } else {
            JOptionPane.showMessageDialog(view, "Invalid username or password.");
        }
    }
}