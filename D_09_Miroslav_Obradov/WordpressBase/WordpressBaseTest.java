package DomaciRad.DomaciZadatak9.WordpressBase;

import DomaciRad.DomaciZadatak9.WordpressPages.WordpressAccountPage;
import DomaciRad.DomaciZadatak9.WordpressPages.WordpressHomePage;
import DomaciRad.DomaciZadatak9.WordpressPages.WordpressLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class WordpressBaseTest {

    public WebDriver driver;
    public WebDriverWait wdwait;

    public WordpressHomePage wordpressHomePage;
    public WordpressLoginPage wordpressLoginPage;
    public WordpressAccountPage wordpressAccountPage;


    @BeforeClass
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wordpressLoginPage = new WordpressLoginPage(driver, wdwait);
        wordpressHomePage = new WordpressHomePage(driver, wdwait);
        wordpressAccountPage = new WordpressAccountPage(driver, wdwait);
    }
    @AfterClass
    public void tearDown(){
        //driver.quit();

    }
}
