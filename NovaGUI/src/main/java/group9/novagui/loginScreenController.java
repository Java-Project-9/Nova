package group9.novagui;

import java.io.IOException;
import javafx.fxml.FXML;

public class loginScreenController {

    @FXML
    private void logInClick() throws IOException {  //Add code for login check here
        App.setRoot("MainScreen");  //Switches to main screen
        Account newAcc = new Account("user","pw");
    }
}
