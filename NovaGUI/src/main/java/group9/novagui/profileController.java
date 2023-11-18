package group9.novagui;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 *
 * @author Nathan
 */

public class profileController {
    
    @FXML
    private void toMainClick() throws IOException {
        App.setRoot("MainScreen");
    }
    
}
