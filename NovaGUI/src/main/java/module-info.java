module group9.novagui {
    requires javafx.controls;
    requires javafx.fxml;

    opens group9.novagui to javafx.fxml;
    exports group9.novagui;
}
