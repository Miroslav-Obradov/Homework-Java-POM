package DomaciRad.DomaciZadatak9.WordpressTests;

import DomaciRad.DomaciZadatak9.WordpressBase.WordpressBaseTest;
import DomaciRad.DomaciZadatak9.WordpressPages.WordpressHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WordpressTestPage extends WordpressBaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://worpress.com/");
    }

    @Test
    public void userCanLogIn() throws InterruptedException {

        wordpressHomePage.clickOnLoginButton();
        wordpressLoginPage.insertUsername("lepotestime@gmail.com");
        wordpressLoginPage.clickContinueButton();
        wordpressLoginPage.insertPassword("ITBootcamp");
        wordpressLoginPage.clickContinueButton();
        Assert.assertEquals(wordpressAccountPage.getProfileName().getText(), "lepotestime.wordpress.com");
    }
}
