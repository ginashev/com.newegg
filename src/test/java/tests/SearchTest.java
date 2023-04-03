package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Login Tests")
public class SearchTest extends BaseTest{
    @Test(priority = 0, description = "Search item at the Home  Page")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Verify search field and result")
    @Story("Search field")
    public void searchAndResultTest() {
        String searchItem =  "Logitech G502";
        homePage
                .openHomePage()
                .verifyHomePageTitle()
                .enterSearchItem(searchItem)
                .pressSearchButton()
                .verifySearchResultTopBarText(searchItem)
                .verifySearchResultNavText(searchItem.toUpperCase())
                .verifyPageHasResult()
                .addAnyItemToTheCard();
    }

}
