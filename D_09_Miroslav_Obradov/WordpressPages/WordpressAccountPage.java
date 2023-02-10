package DomaciRad.DomaciZadatak9.WordpressPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordpressAccountPage {
        public WebDriver driver;
        public WebDriverWait wdwait;

        WebElement profileName;



        public WordpressAccountPage(WebDriver driver, WebDriverWait wdwait) {
                this.driver = driver;
                this.wdwait = wdwait;
        }
        public WebElement getProfileName() throws InterruptedException {
                Thread.sleep(3000);
                wdwait.until(ExpectedConditions.urlToBe("https://wordpress.com/home/lepotestime.wordpress.com"));
                wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("site__domain"))));
                return driver.findElement(By.className("site__domain"));
        }


        }
