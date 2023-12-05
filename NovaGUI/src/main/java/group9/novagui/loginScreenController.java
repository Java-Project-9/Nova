package group9.novagui;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;

public class loginScreenController {
    
    private static final String FILEPATH = "user1.txt"; // constant
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
        if(tfUsername.getText().equals(readFromFile("username"))){
            if(pfPassword.getText().equals(readFromFile("password"))){
                Account.createAccount(tfUsername.getText(),pfPassword.getText()); //creates account details object for further use in client.
                App.setRoot("MainScreen");  //Switches to main screen
                loginPressCounter = 0;
                labelSignInError.setText("");
            }
            else{
                labelSignInError.setText("The username or password you entered is wrong. (" + loginPressCounter + ")"); //counter for login attempts
            }           
        }
        else{
            labelSignInError.setText("The username or password you entered is wrong. (" + loginPressCounter + ")");
        }
    }
    @FXML
    private void createAccountClick() throws IOException{ //Takes the info inputted on fields and inputs to the txt file to create account.
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION); //Created an confirmation alert for create account button click
        alert.setTitle("Create Account Alert");
        alert.setContentText("Are you sure you want to create an account?");
        alert.showAndWait().ifPresent(response ->{
            if(response == ButtonType.OK){    //Confirmation for creating account
                try{             
                    Account.createAccount(tfUsername.getText(),pfPassword.getText()); //Refers to account function in creating account
                    //profile object instantiation
                    System.out.printf("%s %s", tfUsername.getText(),pfPassword.getText());
                    App.setRoot("MainScreen");
                }
                catch(IOException e){
                    e.printStackTrace(System.out);
                }
            }
        });   
    }
    
    
    public String readFromFile(String fieldName) { //Copied code from Rania's account in order to read through txt file for login
        
        try (Scanner scanner = new Scanner(new File(FILEPATH))) {
            Pattern pattern = Pattern.compile(fieldName + ": '\\s*(.*?)\\s*'");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Matcher match = pattern.matcher(line);

                if (match.find()) {
                    return match.group(1);
                } else {
                    System.out.println("Field not found: " + fieldName);
                    return null;
                }
            }
        System.out.println("Did not enter while loop, returned null / field not found");
        return null;
        } catch (IOException e) {
            e.printStackTrace(System.out);
            return null;
        }
    }
}
