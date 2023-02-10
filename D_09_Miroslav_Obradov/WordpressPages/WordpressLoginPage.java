package DomaciRad.DomaciZadatak9.WordpressPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordpressLoginPage {

    public WebDriver driver;
    public WebDriverWait wdwait;

    WebElement emailUsernameField;
    WebElement passwordField;
    WebElement continueButton;
    WebElement loginButton;
    public WordpressLoginPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }
    

    public WebElement getEmailUsernameField() {
        return driver.findElement(By.id("usernameOrEmail"));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.cssSelector(".button.form-button.is-primary"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }
    public WebElement getLoginButton() {
        return loginButton;
    }
    //-----------------------------------------------------------

    public void insertUsername(String username) {
        wdwait.until(ExpectedConditions.urlToBe("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F"));
        getEmailUsernameField().clear();
        getEmailUsernameField().sendKeys(username);
}
    public void insertPassword(String password) {
        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("password"))));
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    public void clickContinueButton(){
            getContinueButton().click();
    }

    public void clickLoginButton(){
        getLoginButton().click();
    }
}