package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import tests.BaseTest;

public class SearchResultPage extends  BasePage {
    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    /**
     * Constructor
     */
    public SearchResultPage (WebDriver driver) {
        super(driver);
    }
    By searchResultTextAtNavBreadcrumb = By.cssSelector(".breadcrumb .is-current");
    By searchResultTextTopBar = By.cssSelector(".nav-x-body-top-bar .page-title-text");
    By itemsList =  By.cssSelector(".item-cells-wrap .item-cell");
    By addToCardButton = By.xpath("//button[contains(@class, 'btn') and text() = 'Add to cart ']");

    public SearchResultPage verifySearchResultTopBarText(String text){
        logger.info("Verify text at Top Bar");
        Assert.assertEquals(getText(searchResultTextAtNavBreadcrumb), "Search Results: \"" + text + "\"" , "Text at Top bar is not equal to expected. " );
        return this;
    }

    public SearchResultPage verifySearchResultNavText(String text){
        logger.info("Verify text at navigator");
        Assert.assertEquals(getText(searchResultTextTopBar), "\"" + text + "\"", "Text at navigator is not equal to expected. " );
        return this;
    }

    public SearchResultPage verifyPageHasResult(){
        logger.info("Verify text at navigator");
        var allItemsList = driver.findElements(itemsList);
        Assert.assertTrue(allItemsList.size() > 0,  "Text at navigator is not equal to expected. " );
        return this;
    }
    public SearchResultPage addAnyItemToTheCard(){
        logger.info("Add item to the card");
        click(addToCardButton);
        return this;
    }
}
