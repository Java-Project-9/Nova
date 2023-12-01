/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group9.novagui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
//import java.io.File;
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
        private String totalTime;
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
            newProfile.updateSaveFile("12");
            return newProfile;
        }
//
//        private void saveAccountData() {
//            try (BufferedWriter writer = new BufferedWriter(new FileWriter (filePath, true))) {
//                File file = new File(filePath);
//                if (!file.exists()) {
//                    file.createNewFile();
//                }
//
//                String formattedData = String.format("nickname: '%s', timeTotal: '%s'\n", nickName, timeCalc());
//                writer.write(formattedData);
//            } catch (IOException except) {
//                except.printStackTrace(System.out);
//            }
//        }

        public String getNickName(){return nickName;}
        public void setNickName(String nickName){
            this.nickName = nickName;
        }

        /*
        supposed the getLogIn time to be int instead of Time variable
        public int getHourLogin(){return timeLogin.getHour();}
        or 
        public time getLoginTime(){return timeLogin;}

        public void setTimeLogin(time timeLogin){this.timeLogin = timeLogin;}

        and the same will be for logout
        */

    //    public String getSaveFile(){return saveFile;}
    //    public void setSaveFile (String saveFile){this.saveFile = saveFile;}

        public int timeCalc(){
        return timeLogin.getHour()-timeLogout.getHour();
        }

    //    public void updateSaveFile(String saveFile){
    //        //suppose to be update not to be replaced so how to add the data in the txt file not replacing
    //        this.saveFile = saveFile;
    //    }
// Rania's test code -----------------------------------------------------------------------------------------------------------------------//
        public void updateSaveFile(String newTotalTime) {
        // Reading from existing file:
        String existingContent = readFromFile("username");

        Pattern totalTimePattern = Pattern.compile("totaltime: '\\s*(.*?)\\s*");
        Matcher totalTimeMatcher = totalTimePattern.matcher(existingContent);

        // Checking to see if the totalTime already exists in the text file
        if (totalTimeMatcher.find()) {
            String updatedContent = existingContent.replaceFirst(totalTimeMatcher.group(1), newTotalTime);
            
            writeToFile(filePath, updatedContent);
        } else {
            // Adding the total time. Please note the totalTime again as placeholder for your calculations.
            String updatedContent = existingContent + String.format(", nickname: '%s', totaltime: '%s'", nickName, totalTime);

            // Using the Helper method to actually write the content.
            writeToFile(filePath, updatedContent);
        }
    }
        private String readFromFile(String fieldName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Regex looking for pattern that has the fieldName:
            Pattern pattern = Pattern.compile(fieldName + ": '\\s*(.*?)\\s*'");

            StringBuilder content = new StringBuilder();
            String line;

            // This is to check if the pattern actually matches what's in the file. If something is going to go wrong, it might be here...
            while (( line = reader.readLine()) != null) {
                content.append(line);

                Matcher match = pattern.matcher(line);

                if (match.find()) {
                    return match.group(1);
                } else {
                    System.out.println("Field not found.");
                    return null;
                }
            }

            return content.toString();

        } catch (IOException e) {
            e.printStackTrace(System.out);
            return null;
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
