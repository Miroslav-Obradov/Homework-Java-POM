package HerokuApp.HerokuAppTests;

import HerokuApp.HerokuAppBase.HerokuAppBaseTest;
import HerokuApp.HerokuAppPages.HerokuAppLoginPage;
import HerokuApp.HerokuAppPages.HerokuAppLogoutPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HerokuAppLoginTest extends HerokuAppBaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(LoginURL);
        herokuAppLoginPage = new HerokuAppLoginPage();
        herokuAppLogoutPage = new HerokuAppLogoutPage();
    }

    @Test (priority = 10)
    public void userCanLogIn() {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);

        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLogoutPage.getNotificationText(), "You logged into a secure area!\n" + "×");
    }
    @Test (priority = 20)
    public void userCannotLogInWithInvalidUsername() {
        String invalidUsername = excelReader.getStringData("Login", 1, 2);
        String validPassword = excelReader.getStringData("Login", 1, 1);

        herokuAppLoginPage.insertUsername(invalidUsername);
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getNotificationText(), "Your username is invalid!\n" + "×");
    }
    @Test (priority = 30)
    public void userCannotLogInWithInvalidPassword() {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String invalidPassword = excelReader.getStringData("Login", 1, 3);

        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.inserPassword(invalidPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getNotificationText(), "Your password is invalid!\n" + "×");
    }
    @Test (priority = 40)
    public void userCannotLogInWithInvalidUsernameAndPassword() {
        String invalidUsername = excelReader.getStringData("Login", 2, 2);
        String invalidPassword = excelReader.getStringData("Login", 2, 3);

        herokuAppLoginPage.insertUsername(invalidUsername);
        herokuAppLoginPage.inserPassword(invalidPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getNotificationText(), "Your username is invalid!\n" + "×");
    }
    @Test (priority = 50)
    public void userCannotLogInWithEmptyUsernameAndPasswordFields() {


        herokuAppLoginPage.insertEmptyUsername();
        herokuAppLoginPage.insertEmptyPassword();
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getNotificationText(), "Your username is invalid!\n" + "×");
    }
    @Test (priority = 60)
    public void userCannotLogInWithEmptyUsernameField() {

        String validPassword = excelReader.getStringData("Login", 1, 1);

        herokuAppLoginPage.insertEmptyUsername();
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getNotificationText(), "Your username is invalid!\n" + "×");
    }
    @Test (priority = 70)
    public void userCannotLogInWithEmptyPasswordField() {
        String validUsername = excelReader.getStringData("Login", 1, 0);

        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.insertEmptyPassword();
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLoginPage.getNotificationText(), "Your password is invalid!\n" + "×");
    }
    @Test (priority = 80)
    public void userCanLogOut() {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);

        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLogoutPage.getNotificationText(), "You logged into a secure area!\n" + "×");
        herokuAppLogoutPage.clickOnlogoutButton();
        Assert.assertEquals(herokuAppLogoutPage.getNotificationText(), "You logged out of the secure area!\n" + "×");
    }
    @Test (priority = 90)
    public void loginButtonTextExists() {

        Assert.assertEquals(herokuAppLoginPage.validateLogInButtonText(), "Login");
    }
    @Test (priority = 100)
    public void usernameFieldTitleIsPresent() {

        Assert.assertEquals(herokuAppLoginPage.usernameFieldTitle(), "Username");
    }
    @Test (priority = 110)
    public void passwordFieldTitleIsPresent() {

        Assert.assertEquals(herokuAppLoginPage.passwordFieldTitle(), "Password");
    }
    @Test (priority = 120)
    public void loginPageTitleIsPresent() {

        Assert.assertEquals(herokuAppLoginPage.validateLoginPageTitle(), "Login Page");
    }
    @Test (priority = 130)
    public void logoutPageTextIsPresent() {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);

        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLogoutPage.validateLogoutPageTitle(), "Secure Area");
    }
    @Test (priority = 140)
    public void usernameNotificationIsClosed() throws InterruptedException {
        String invalidUsername = excelReader.getStringData("Login", 1, 2);
        String validPassword = excelReader.getStringData("Login", 1, 1);

        herokuAppLoginPage.insertUsername(invalidUsername);
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        herokuAppLoginPage.clickOnCloseNotification();
        Assert.assertFalse(herokuAppLoginPage.errorMessageClosed());
    }
    @Test (priority = 150)
    public void passwordNotificationIsClosed() throws InterruptedException {
        String invalidUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 3);

        herokuAppLoginPage.insertUsername(invalidUsername);
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        herokuAppLoginPage.clickOnCloseNotification();
        Assert.assertFalse(herokuAppLoginPage.errorMessageClosed());
    }
    @Test (priority = 160)
    public void successfulLogInNotificationIsClosed() throws InterruptedException {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);

        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        herokuAppLoginPage.clickOnCloseNotification();
        Assert.assertFalse(herokuAppLoginPage.errorMessageClosed());
        }
    @Test (priority = 170)
    public void validateInvalidUsernameNotificationColour() {
        String invalidUsername = excelReader.getStringData("Login", 1, 2);
        String validPassword = excelReader.getStringData("Login", 1, 1);

        herokuAppLoginPage.insertUsername(invalidUsername);
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertTrue(herokuAppLoginPage.notificationColour());
    }
    @Test (priority = 180)
    public void validateInvalidPasswordNotificationColour() {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String invalidPassword = excelReader.getStringData("Login", 1, 3);

        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.inserPassword(invalidPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertTrue(herokuAppLoginPage.notificationColour());
    }
    @Test (priority = 190)
    public void validateLoginNotificationColour() {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String invalidPassword = excelReader.getStringData("Login", 1, 1);

        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.inserPassword(invalidPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertTrue(herokuAppLogoutPage.notificationColour());
    }
    @Test (priority = 200)
    public void userCannotLoginWithBackButton() throws InterruptedException {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);

        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLogoutPage.getNotificationText(), "You logged into a secure area!\n" + "×");
        herokuAppLogoutPage.clickOnlogoutButton();
        herokuAppLogoutPage.clickOnBackButton();
        Assert.assertFalse(herokuAppLogoutPage.presenceOfLogoutButton());
    }
}
