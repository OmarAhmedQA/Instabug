package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC3_WrongSearch extends BaseTestCase {

    @Test
    public void validateCorrectionOfKeyword() {
        googleSearch.enterSearchKeyword("egyp");
        googleSearch.clickEnter();
        Assert.assertTrue(googleSearch.correctionExists());
    }
}