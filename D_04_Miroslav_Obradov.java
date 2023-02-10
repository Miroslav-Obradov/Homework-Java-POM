package DomaciRad;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//Asertacija kada pokusamo da se ulogujemo bez unosenja lozinke
public class DomaciZadatak4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com");
        driver.findElement(By.id("menu-item-20")).click();

        WebElement login = driver.findElement(By.linkText("Test Login Page"));
        login.click();

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("student");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        WebElement error = driver.findElement(By.id("error"));
        Assert.assertTrue(error.isDisplayed());

        WebElement errorMessage = driver.findElement(By.id("error"));
        String actualTitle = errorMessage.getText();
        String expectedTitle = "Your password is invalid!";
        Assert.assertEquals(actualTitle, expectedTitle);

        String expectedLogoutURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedLogoutURL);
    }
}
