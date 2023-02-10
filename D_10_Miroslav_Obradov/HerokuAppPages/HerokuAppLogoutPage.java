package HerokuApp.HerokuAppPages;

import HerokuApp.HerokuAppBase.HerokuAppBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppLogoutPage extends HerokuAppBaseTest {
    public HerokuAppLogoutPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "flash")
    public WebElement Notification;
    @FindBy(css = ".icon-2x.icon-signout")
    public WebElement LogOutButton;
    @FindBy(xpath = "//*[@id=\"content\"]/div/h2")
    WebElement LogoutPageTitle;
    @FindBy(id = "flash")
    WebElement NotificationColour;


    //-----------------------

    public String getNotificationText() {
        return Notification.getText();
    }
    public void clickOnlogoutButton(){

        LogOutButton.click();
    }
    public String validateLogoutPageTitle(){

        return LogoutPageTitle.getText();
    }
    public void clickOnBackButton(){

        driver.navigate().back();
    }
    public boolean notificationColour(){

        boolean colour = false;
        if(NotificationColour.getCssValue("background-color").equals("rgba(93, 164, 35, 1)")){
            colour = true;
        }
        return colour;
    }
    public boolean presenceOfLogoutButton() throws InterruptedException {
        Thread.sleep(2000);
        boolean present = false;
        try {
            LogOutButton.isDisplayed();
            present = true;

        } catch (Exception e) {

        }
        return present;
    }

}
