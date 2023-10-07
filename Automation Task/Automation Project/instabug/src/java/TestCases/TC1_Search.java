package TestCases;

import Page.QueryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1_Search extends BaseTestCase{

    @Test
    public void validateSearchResultContainsKeyword() {
        googleSearch.enterSearchKeyword("instabug");
        QueryPage queryPage = googleSearch.clickEnter();
        String firstResult = queryPage.getSearchResult();
        Assert.assertTrue(firstResult.contains("instabug"), "The first result does not contain the keyword 'instabug'.");
    }

}