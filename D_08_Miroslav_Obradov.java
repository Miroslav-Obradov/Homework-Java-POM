package DomaciRad;

import com.google.gson.annotations.Until;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

//Ulogujte se na demoqa preko cookies-a, dodati dve knjige na svoj nalog,
// zatim se izlogovati brisanjem cookies-a.
//Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu.
public class DomaciZadatak8 {


    WebDriver driver;
    WebDriverWait wdwait;
    JavascriptExecutor js;


    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void pageSetUp() {
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/login");
        Cookie cookie1 = new Cookie("userName", "Peraperic");
        Cookie cookie2 = new Cookie("userID", "278118ee-09f3-476a-9189-47ad564780a8");
        Cookie cookie3 = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IlBlcmFwZXJpYyIsInBhc3N3b3JkIjoiMUEyYjNjNCEiLCJpYXQiOjE2NzM3MTYxMDF9.oUWUPX_gQSFU6YPP8-L3Vj3KJAJf_4fv3VtA1_ZcxAY");
        Cookie cookie4 = new Cookie("expires", "2023-01-21T17%3A08%3A21.123Z");
        driver.manage().addCookie(cookie1);
        driver.manage().addCookie(cookie2);
        driver.manage().addCookie(cookie3);
        driver.manage().addCookie(cookie4);
        driver.navigate().refresh();
    }
    @Test
    public void loginAndAddOneBook() throws InterruptedException {

        js.executeScript("window.scrollBy(0,1000)");
        List<WebElement> bookStore = driver.findElements(By.id("item-2"));
        for (int i = 0; i < bookStore.size(); i++) {
            if (bookStore.get(i).getText().equals("Book Store")) {
                bookStore.get(i).click();
                break;
            }
        }
        Thread.sleep(3000);
        wdwait.until(ExpectedConditions.urlToBe("https://demoqa.com/books"));
        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("see-book-Git Pocket Guide"))));
        WebElement addBook1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        addBook1.click();
        js.executeScript("window.scrollBy(0,1000)");
        List<WebElement> addNewRecordButton = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < addNewRecordButton.size(); i++) {
            if (addNewRecordButton.get(i).getText().equals("Add To Your Collection")) {
                addNewRecordButton.get(i).click();
                break;
            }
        }
        Thread.sleep(4000);
        Alert alert = driver.switchTo().alert(); // switch to alert
        alert.accept();

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        driver.get("https://demoqa.com/login");
        WebElement userNameField = driver.findElement(By.id("userName"));
        userNameField.sendKeys("Peraperic");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("1A2b3c4!");

        js.executeScript("window.scrollBy(0,1000)");
        List<WebElement> logginButton = driver.findElements(By.cssSelector(".btn.btn-primary"));
        logginButton.get(0).click();

        Thread.sleep(5000);
        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Git Pocket Guide"))));
        WebElement book1 = driver.findElement(By.linkText("Git Pocket Guide"));
        Assert.assertEquals(book1.getText(),"Git Pocket Guide");

        WebElement deleteButton = driver.findElement(By.id("delete-record-undefined"));
        Assert.assertTrue(deleteButton.isDisplayed());
    }
    @Test
    public void loginAndAddTwoBooks() throws InterruptedException {

        js.executeScript("window.scrollBy(0,1000)");
        List<WebElement> bookStore = driver.findElements(By.id("item-2"));
        for (int i = 0; i < bookStore.size(); i++) {
            if (bookStore.get(i).getText().equals("Book Store")) {
                bookStore.get(i).click();
                break;
            }
        }
        Thread.sleep(3000);
        wdwait.until(ExpectedConditions.urlToBe("https://demoqa.com/books"));
        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("see-book-Git Pocket Guide"))));
        WebElement addBook1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        addBook1.click();
        js.executeScript("window.scrollBy(0,1000)");
        List<WebElement> addNewRecordButton = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < addNewRecordButton.size(); i++) {
            if (addNewRecordButton.get(i).getText().equals("Add To Your Collection")) {
                addNewRecordButton.get(i).click();
                break;
            }
        }
        Thread.sleep(4000);
        Alert alert = driver.switchTo().alert(); // switch to alert
        alert.accept();

        List<WebElement> addNewRecordButton2 = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < addNewRecordButton2.size(); i++) {
            if (addNewRecordButton2.get(i).getText().equals("Back To Book Store")) {
                addNewRecordButton2.get(i).click();
                break;
            }
        }
        Thread.sleep(3000);
        wdwait.until(ExpectedConditions.urlToBe("https://demoqa.com/books"));
        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"))));
        WebElement addBook2 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        addBook2.click();
        js.executeScript("window.scrollBy(0,1000)");
        addNewRecordButton = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < addNewRecordButton.size(); i++) {
            if (addNewRecordButton.get(i).getText().equals("Add To Your Collection")) {
                addNewRecordButton.get(i).click();
                break;
            }
        }
        Thread.sleep(4000);
        alert = driver.switchTo().alert(); // switch to alert
        alert.accept();
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        driver.get("https://demoqa.com/login");
        WebElement userNameField = driver.findElement(By.id("userName"));
        userNameField.sendKeys("Peraperic");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("1A2b3c4!");

        js.executeScript("window.scrollBy(0,1000)");
        List<WebElement> logginButton = driver.findElements(By.cssSelector(".btn.btn-primary"));
        logginButton.get(0).click();

        Thread.sleep(5000);
        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Git Pocket Guide"))));
        WebElement book1 = driver.findElement(By.linkText("Git Pocket Guide"));
        Assert.assertEquals(book1.getText(),"Git Pocket Guide");

        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Learning JavaScript Design Patterns"))));
        WebElement book2 = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        Assert.assertEquals(book2.getText(),"Learning JavaScript Design Patterns" );

        WebElement deleteButton = driver.findElement(By.id("delete-record-undefined"));
        Assert.assertTrue(deleteButton.isDisplayed());
    }
    @Test
    public void loginAndAddThreeBooks() throws InterruptedException {

        js.executeScript("window.scrollBy(0,1000)");
        List<WebElement> bookStore = driver.findElements(By.id("item-2"));
        for (int i = 0; i < bookStore.size(); i++) {
            if (bookStore.get(i).getText().equals("Book Store")) {
                bookStore.get(i).click();
                break;
            }
        }
        Thread.sleep(3000);
        wdwait.until(ExpectedConditions.urlToBe("https://demoqa.com/books"));
        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("see-book-Git Pocket Guide"))));
        WebElement addBook1 = driver.findElement(By.id("see-book-Git Pocket Guide"));
        addBook1.click();
        js.executeScript("window.scrollBy(0,1000)");
        List<WebElement> addNewRecordButton = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < addNewRecordButton.size(); i++) {
            if (addNewRecordButton.get(i).getText().equals("Add To Your Collection")) {
                addNewRecordButton.get(i).click();
                break;
            }
        }
        Thread.sleep(4000);
        Alert alert = driver.switchTo().alert(); // switch to alert
        alert.accept();

        List<WebElement> addNewRecordButton2 = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < addNewRecordButton2.size(); i++) {
            if (addNewRecordButton2.get(i).getText().equals("Back To Book Store")) {
                addNewRecordButton2.get(i).click();
                break;
            }
        }
        //Thread.sleep(4000);
        js.executeScript("window.scrollBy(0,1000)");
        WebElement addBook2 = driver.findElement(By.id("see-book-Learning JavaScript Design Patterns"));
        addBook2.click();
        addNewRecordButton = driver.findElements(By.id("addNewRecordButton"));
        for(int i=0; i<addNewRecordButton.size(); i++) {
            if (addNewRecordButton.get(i).getText().equals("Add To Your Collection")){
                js.executeScript("window.scrollBy(0,1000)");
                addNewRecordButton.get(i).click();
                break;
            }
        }
        Thread.sleep(4000);
        alert = driver.switchTo().alert(); // switch to alert
        alert.accept();
        List<WebElement> addNewRecordButton3 = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < addNewRecordButton3.size(); i++) {
            if (addNewRecordButton3.get(i).getText().equals("Back To Book Store")) {
                addNewRecordButton3.get(i).click();
                break;
            }
        }
        js.executeScript("window.scrollBy(0,1000)");
        WebElement addBook3 = driver.findElement(By.id("see-book-Designing Evolvable Web APIs with ASP.NET"));
        addBook3.click();
        js.executeScript("window.scrollBy(0,1000)");
        addNewRecordButton = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < addNewRecordButton.size(); i++) {
            if (addNewRecordButton.get(i).getText().equals("Add To Your Collection")) {
                addNewRecordButton.get(i).click();
                break;
            }
        }
        Thread.sleep(5000);

        alert = driver.switchTo().alert(); // switch to alert
        alert.accept();
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        driver.get("https://demoqa.com/login");
        WebElement userNameField = driver.findElement(By.id("userName"));
        userNameField.sendKeys("Peraperic");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("1A2b3c4!");

        js.executeScript("window.scrollBy(0,1000)");
        List<WebElement> logginButton = driver.findElements(By.cssSelector(".btn.btn-primary"));
        logginButton.get(0).click();

        Thread.sleep(5000);
        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Git Pocket Guide"))));
        WebElement book1 = driver.findElement(By.linkText("Git Pocket Guide"));
        Assert.assertEquals(book1.getText(),"Git Pocket Guide" );

        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Learning JavaScript Design Patterns"))));
        WebElement book2 = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        Assert.assertEquals(book2.getText(),"Learning JavaScript Design Patterns" );

        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Designing Evolvable Web APIs with ASP.NET"))));
        WebElement book3 = driver.findElement(By.linkText("Designing Evolvable Web APIs with ASP.NET"));
        Assert.assertEquals(book3.getText(), "Designing Evolvable Web APIs with ASP.NET");

        WebElement deleteButton = driver.findElement(By.id("delete-record-undefined"));
        Assert.assertTrue(deleteButton.isDisplayed());
    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}