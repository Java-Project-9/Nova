package group9.novagui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;

public class loginScreenController { //implements Initializable
    
    int loginPressCounter = 0;
    @FXML
    private TextField tfUsername;
    @FXML
    private Label labelSignInError;
    @FXML
    private void logInClick() throws IOException {  //Add code for login check here
        loginPressCounter++;
        if(tfUsername.getText().equals("user")){
            App.setRoot("MainScreen");  //Switches to main screen
            loginPressCounter = 0;
            labelSignInError.setText("");
        }
        else{
            labelSignInError.setText("The username or password you entered is wrong. (" + loginPressCounter + ")");
        }
//        Account newAcc = new Account("user","pw"); 
    }
}
