import Controller.LogInController;
import Model.UserLogin;
import View.LoginView;

public class Main {
    public static void main(String[] args) {

        // prepare the database
        UserLogin.initialize();

        //  creates UI
        LoginView view = new LoginView();

        // connects the controller to the UI
        new LogInController(view);
    }
}