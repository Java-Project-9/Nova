package group9.novagui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;

/**
 *
 * @author Nathan
 */

public class profileScreenController {
    Time t1 = new Time(23, 18, 23);
//    Profile testProfile = Profile.createProfile("nickname", t1, t1);
//    testProfile.txtAppend();
//    newAccount.getUsername;
    private static final String FILEPATH = "user1.txt"; // constant
    @FXML
    private void toMainClick() throws IOException {
        App.setRoot("MainScreen");
    }
    @FXML
    private void onSaveClick() throws IOException {
//        txtAppend();
    }
    public void txtAppend(String username){
            String textToAppend = "15";
            String[] lineArr = new String[20];
            
            try {
            // Read the existing content of the file
            Path fP = Path.of("C:\\Users\\Nathan\\Desktop\\JavaAssignments\\Nova\\NovaGUI\\user1.txt");
            String existingContent = Files.readString(fP);

            // Append the new text to the existing content
            
            try (BufferedReader reader = new BufferedReader(new FileReader(FILEPATH))) {
                String line;
                String result = "";
                while ((line = reader.readLine()) != null) {
                    lineArr = line.split("\n", 0);
                    for(String a : lineArr){
                        System.out.println(a);
                        if(true){
                            a = a + textToAppend;
                            System.out.println(a);
                        }
                        result = result + a + '\n';
                    }
                }
                System.out.println(result);
                Files.write(fP, result.getBytes(), StandardOpenOption.WRITE);
                
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                }   
        }catch (IOException e) {
            e.printStackTrace(System.out);
        }   
    }
    public String readFromFile(String fieldName) {
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
        return null; // ?? if I remove this, it gives me an error. i need to figure it out bro
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}