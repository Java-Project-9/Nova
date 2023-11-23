package group9.novagui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Account {
    private String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username; // this is a placeholder, depends on where validation happens
        saveAccountData();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password; // this is a placeholder
        saveAccountData();
    }

    // createAccount can also do validation for username/pw creation
    public static Account createAccount(String username, String password) {
        // validating input

        // checking for duplicate username
        
        // validating pw ex
        if (password.length() <= 8 || password.length() >= 15) {
            // maybe better to throw illegal arg if it's built in for pw validation
            System.out.println("Invalid password. Must be between 8 - 15 characters.");
        }

        Account newAccount = new Account(username, password);

        newAccount.saveAccountData();

        return newAccount;
    }

    // saving to the .txt file
    private void saveAccountData() {
        try {
            FileWriter user_file = new FileWriter("user_info.txt");
            BufferedWriter writer = new BufferedWriter(user_file);
            
            String formattedData = String.format("user1 username: '%s', password: '%s'", username, password);
            
            writer.write(formattedData);
            writer.newLine();

            writer.close();
        } catch (IOException except) {
            except.printStackTrace();
        }
        
    }

    // do we need a method to read data from the .txt

    public boolean login(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
        saveAccountData();
    }

    public void deleteAccount() {
        // delete account or mark as inactive?
    }
}