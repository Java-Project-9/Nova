/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group9.novagui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
//import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author omaro
 */
public class Profile{
   
        private Account account;
        private String nickName;
        private Time timeLogin;
        private Time timeLogout;
        private int totalTime;
        private static final String filePath = "user1.txt"; // constant

        //add timelogin and timelogout parameters
        //check for repeated nicknames
        public Profile (String nickName, Time timeLogin, Time timeLogout){
            this.nickName = nickName;
    //        this.saveFile = saveFile;
            this.timeLogout = timeLogout;
            this.timeLogin  = timeLogin;
        }
        public static Profile createProfile(String nickname, Time timeLogin, Time timeLogout) { // must be time Total
            Profile newProfile = new Profile(nickname, timeLogin, timeLogout);
//            newProfile.updateSaveFile("12");
            return newProfile;
        }

        public String getNickName(){return nickName;}
        public void setNickName(String nickName){
            this.nickName = nickName;
        }


        public int timeCalc(){
        return timeLogin.getHour()-timeLogout.getHour();
        }

        public void txtAppend(){
            String textToAppend = "15"; //totalTime
            String[] lineArr = new String[20];
            
            try {
            // Read the existing content of the file
            Path fP = Path.of("C:\\Users\\Nathan\\Desktop\\JavaAssignments\\Nova\\NovaGUI\\user1.txt");
            String existingContent = Files.readString(fP);

            // Append the new text to the existing content
            String newContent = existingContent + textToAppend;
            
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
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
           

        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
            
        }
        private void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace(System.out);
          }
        }
        
        
    }
