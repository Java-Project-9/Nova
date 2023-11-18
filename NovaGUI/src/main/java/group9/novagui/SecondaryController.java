package group9.novagui;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("loginScreen");
    }
    @FXML
    private void toProfileClick() throws IOException {
        App.setRoot("profileScreen");
    }
}