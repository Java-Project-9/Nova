package group9.novagui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;

public class loginScreenController {
    
    int loginPressCounter = 0;
    @FXML
    private TextField tfUsername;
    @FXML
    private Label labelSignInError;
    @FXML
    private PasswordField pfPassword;
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
    @FXML
    private void createAccountClick() throws IOException{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Create Account Alert");
        alert.setContentText("Are you sure you want to create an account?");
        alert.showAndWait().ifPresent(response ->{
            if(response == ButtonType.OK){
                try{
                    Account.createAccount(tfUsername.getText(),pfPassword.getText());
//                    Account newAccount = new Account(tfUsername.getText(),pfPassword.getText());
                    System.out.printf("%s %s", tfUsername.getText(),pfPassword.getText());
                    App.setRoot("MainScreen");
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        });
        
        
    }
}
