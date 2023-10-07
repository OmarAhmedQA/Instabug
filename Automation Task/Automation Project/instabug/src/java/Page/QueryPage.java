package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QueryPage {
    WebDriver driver;
    private By SearchResult = By.cssSelector("h3>span");
    private By didYouMean = By.cssSelector(".gL9Hy.d2IKib");
    QueryPage(WebDriver driver){
        this.driver = driver;
    }


    public boolean correctionExists() {
        if (driver.findElement(didYouMean) != null) {
            return true;
        }
        return false;
    }
    public String getSearchResult() {
        return driver.findElement(SearchResult).getText().toLowerCase();
    }
}
