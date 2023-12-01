package group9.novagui;

public class AccountTest {
    public static void main(String[] args) {
        // Testing creation
        Time t1 = new Time(23, 18, 23);
        Account testAccount = Account.createAccount("testusername", "testpassword");
        System.out.println("Account created: " + testAccount.getUsername());
        Profile testProfile = Profile.createProfile("nickname", t1, t1);
        

//        // Change password
//        testAccount.changePassword("testPassword", "superSafePassword");
//
//        // I mispelled it that time! Did it catch that? Let's try again
//        testAccount.changePassword("testpassword", "supersupersafepw");
//
//        // Testing login with new password
//        boolean loginSuccess = testAccount.login("testusername", "supersupersafepw");
//
//        System.out.println("Login Success" + loginSuccess);
//
//        // Testing duplicate username
//        Account testAccount2 = Account.createAccount("testusername", "test123");
    }
}