package TestCases;

import org.testng.annotations.Test;
import java.util.ArrayList;

public class TC2_ResultText extends BaseTestCase {

    @Test
    public void validateResults(){
        String word = "egypt";
        googleSearch.enterSearchKeyword(word);
        ArrayList<String> results = googleSearch.getDropDownResults();
        googleSearch.AssertListContainsKeyword(results,word);
    }


}
