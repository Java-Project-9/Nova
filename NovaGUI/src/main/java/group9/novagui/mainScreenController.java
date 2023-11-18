package group9.novagui;

import java.io.IOException;
import javafx.fxml.FXML;

public class mainScreenController {

    @FXML
    private void switchToLogin() throws IOException { //Remove this later
        App.setRoot("loginScreen");
    }
    @FXML
    private void toProfileClick() throws IOException {
        App.setRoot("profileScreen");
    }
}