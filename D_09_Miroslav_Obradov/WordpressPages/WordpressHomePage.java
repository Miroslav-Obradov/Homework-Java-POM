package DomaciRad.DomaciZadatak9.WordpressPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordpressHomePage {

    public WebDriver driver;
    public WebDriverWait wdwait;

    public WordpressHomePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }



    public WebElement getLoginButton() {
        return driver.findElement(By.linkText("Log In"));
    }

    public WebElement getGetStartedButton() {
        return driver.findElement(By.linkText("Get Started"));
    }

    WebElement getStartedButton;
//-----------------------------------------------------------------

    public void clickOnLoginButton() {
        getLoginButton().click();
    }
    public void clickOnGetStartedButton() {
        getGetStartedButton().click();
}
}