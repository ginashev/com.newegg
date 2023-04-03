package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import tests.BaseTest;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class HomePage extends BasePage {
    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    /**
     * Constructor
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Variables
     */
    String baseURL = "https://www.newegg.com/";

    /**
     * Web Elements
     */

    By searchField = By.cssSelector("[title='Search Site']");
    By searchButton = By.cssSelector(".ico.ico-search");
    /**
     * Page Methods
     */
    //Go to Homepage
    public HomePage openHomePage() {
        logger.info("Opening home page.");
        driver.get(baseURL);
        return this;
    }

   public HomePage verifyHomePageTitle(){
       logger.info("Verify Page title");
       Assert.assertEquals(driver.getTitle(), "Top gaming PC & laptop savings. PC parts, & more! | Newegg.com" , "Titles are not equals. " );
       return this;
   }

    public HomePage enterSearchItem(String item){
        logger.info("Enter value in the search field");
        writeText(searchField, item);
        return this;
    }
    public SearchResultPage pressSearchButton(){
        logger.info("Enter value in the search field");
        click(searchButton);
        return new SearchResultPage(driver);
    }
}