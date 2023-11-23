public class AccountTest {
    public static void main(String[] args) {
        Account testAccount = Account.createAccount("testusername", "testpassword");

        testAccount.changePassword("newPassword");

        boolean loginSuccess = testAccount.login("testusername", "testpassword");

        System.out.println("Login Success" + loginSuccess);
    }
}