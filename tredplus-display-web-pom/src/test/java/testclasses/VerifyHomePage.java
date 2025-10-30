package testclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomclasses.Home;
import utility.pombaseclass;

public class VerifyHomePage  {

    WebDriver driver;
    Home home;

    @BeforeClass
    public void setUp() {
        // Load properties
    	pombaseclass.getProperty();

        // Setup Chrome browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Launch Application
        driver.get("https://tredplus.com/");

        // Initialize Page Objects
        home = new Home(driver);
    }

    @Test(priority = 1)
    public void verifyHomeButtonClickable() {
        try {
            home.ClickHomeButton();
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("tredplus.com"), "Home button navigation failed!");
            System.out.println("✅ Home button clicked successfully. Current URL: " + currentUrl);
        } catch (Exception e) {
            Assert.fail("❌ Failed to click Home button: " + e.getMessage());
        }
    }
    @Test(priority = 2)
    public void verifyHomePageTitleText() {
        home.ClickHomeButton(); // click Home
        String actualTitle = home.getHomePageTitleText();

        System.out.println("🔹 Home Page Title Text: " + actualTitle);
        Assert.assertEquals(actualTitle.trim(), 
                            "Invest in verified invoices and earn 10-14%* assured, short-term returns. With Tred+'s guarantee, you can confidently invest, knowing each deal is thoroughly vetted for your security.",
                            "❌ Home page title text does not match expected value!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            //driver.quit();
        }
        System.out.println("🔻 Browser closed after HomePage verification test.");
    }
}
