package HerokuApp.HerokuAppPages;

import HerokuApp.HerokuAppBase.HerokuAppBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HerokuAppLoginPage extends HerokuAppBaseTest {
    public HerokuAppLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    public WebElement Username;

    @FindBy(id = "password")
    public WebElement Password;

    @FindBy(css = ".fa.fa-2x.fa-sign-in")
    public WebElement LogInButton;
    @FindBy(id = "flash")
    public WebElement Notification;
    @FindBy(xpath = "//label[text() = 'Username']")
    WebElement UsernameFieldTitle;
    @FindBy(xpath = "//label[text() = 'Password']")
    WebElement PasswordFieldTitle;
    @FindBy(xpath = "//*[@id=\"content\"]/div/h2")
    WebElement LoginPageTitle;
    @FindBy(className = "close")
    WebElement CloseNotification;
    @FindBy(id = "flash")
    WebElement NotificationColour;









    //----------------------

    public void insertUsername(String username) {
        Username.clear();
        Username.sendKeys(username);
    }

    public void inserPassword(String password) {
        Password.clear();
        Password.sendKeys(password);
    }

    public void clickOnLogInButton() {
        LogInButton.click();
    }
    public String getNotificationText() {
        return Notification.getText();
    }

    public void insertEmptyUsername() {
        Username.clear();
    }
    public void insertEmptyPassword() {
        Password.clear();
    }
    public String validateLogInButtonText(){

        return LogInButton.getText();
    }
    public String usernameFieldTitle(){
        return UsernameFieldTitle.getText();
    }
    public String passwordFieldTitle(){
        return PasswordFieldTitle.getText();
    }
    public String validateLoginPageTitle(){

        return LoginPageTitle.getText();
    }
    public void clickOnCloseNotification() {
        CloseNotification.click();
    }
    public boolean errorMessageClosed() throws InterruptedException {
        Thread.sleep(2000);
        boolean present = false;
        try {
            Notification.isDisplayed();
            present = true;

        } catch (Exception e) {

        }
        return present;
    }
    public boolean notificationColour(){
        boolean colour = false;
        if(NotificationColour.getCssValue("background-color").equals("rgba(198, 15, 19, 1)")){
            colour = true;
        }
        return colour;
    }
}

