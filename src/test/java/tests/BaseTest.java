package tests;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import org.apache.logging.log4j.Logger;

public class BaseTest {
    public WebDriver driver;
    public HomePage  homePage;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void classLevelSetup() {
        logger.info("Tests are starting!");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void methodLevelSetup() {
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void teardown() {
        logger.info("Tests are ending!");
        driver.quit();
    }
}
