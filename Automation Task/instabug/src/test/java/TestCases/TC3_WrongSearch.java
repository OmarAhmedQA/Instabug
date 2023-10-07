package TestCases;

import Page.QueryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC3_WrongSearch extends BaseTestCase {

    @Test
    public void validateCorrectionOfKeyword() {
        googleSearch.enterSearchKeyword("egyp");
        QueryPage  queryPage = googleSearch.clickEnter();
        Assert.assertTrue(queryPage.correctionExists());
    }
}