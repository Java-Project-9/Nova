package group9.novagui;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Account {
    private static final String FILEPATH = "user1.txt"; // constant
    private String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return readFromFile("password");
    }

    public void setUsername(String username) {
        String existingUsername = readFromFile("username");

        if (existingUsername != null && existingUsername.equals(username)) {
            System.out.println("Duplicate username. Please choose another.");
        } else {
            this.username = username;
            saveAccountData();
        }
    }

    public void setPassword(String password) {
        if (password.length() < 8 && password.length() > 15) {
            System.out.println("Invalid password. Must be between 8-15 characters.");
        } else {
            this.password = password;
            saveAccountData();
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
        return username; 
        } catch (IOException e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    public static Account createAccount(String username, String password) {
        Account newAccount = new Account(username, password);
        newAccount.saveAccountData();
        return newAccount;
    }

    // saving to the .txt file
    private void saveAccountData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter (FILEPATH, true))) {
            File file = new File(FILEPATH);
            if (!file.exists()) {
                file.createNewFile();
            }
            
            String formattedData = String.format("username: '%s', password: '%s'\n", username, password);
            writer.write(formattedData);
        } catch (IOException except) {
            except.printStackTrace(System.out);
        }
    }

    public boolean login(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (password.equals(oldPassword)) {
            this.password = newPassword;
            saveAccountData();
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Wrong Password. Unable to change password.");
        }
    }

    public void deleteAccount() {
        // delete account or mark as inactive?
    }
}