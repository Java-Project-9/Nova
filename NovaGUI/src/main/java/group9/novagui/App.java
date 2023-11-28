package group9.novagui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */

public class App extends Application {

    private static void SaveUserName(String nickname, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(
                filePath, true))) { // set append to Tru
            writer.write(nickname); // Append Nickname
            writer.newLine(); // Insert Newline
        } catch (IOException e) { // InputOuput Exception
            System.out.println("An error occured: " + e.getMessage());
        }
    }
    private static void ReadUserName(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(
        filePath))) {
            String userName = reader.readLine(); // Read First Line
            // How to read a a specific line?
            System.out.println("Read userName: " + userName); // Test Print
        } catch (IOException e) {
            System.out.println("An error occured: " + e.getMessage());
        }
    }
    
    
    
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("loginScreen"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        String nickname = "1coolnathan";

        // Specify the file path (path\\fileName.txt)
        String filePath = "C:\\Users\\Nathan\\Desktop\\JavaAssignments\\Nova\\user1.txt"; //Note that this references an already made text file.
        
//        SaveUserName(nickname, filePath);

//        System.out.println("Nickname has been saved to the file.");
        
//        ReadUserName(filePath);
        
        launch();
    }

}