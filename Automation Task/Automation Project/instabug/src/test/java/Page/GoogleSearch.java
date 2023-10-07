package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GoogleSearch {
    private WebDriver driver;
    private By searchBox = By.name("q");
    private By SearchResult = By.cssSelector("h3>span");
    private By didYouMean = By.cssSelector(".gL9Hy.d2IKib");

    public GoogleSearch(WebDriver driver) {
        this.driver = driver;
        this.driver.get("https://www.google.com");
    }

    public void enterSearchKeyword(String keyword) {
        driver.findElement(searchBox).sendKeys(keyword);
    }

    public void clickEnter() {
        driver.findElement(searchBox).submit();
    }

    public String getSearchResult() {
        return driver.findElement(SearchResult).getText().toLowerCase();
    }

    public ArrayList<String> getDropDownResults() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("wM6W7d")));

        List<WebElement> elementsValue = driver.findElements(By.className("wM6W7d"));

        ArrayList<String> textValues = new ArrayList<>();

        for (WebElement element : elementsValue) {
            textValues.add(element.getText());
        }
        return textValues;
    }

    public void AssertListContainsKeyword(ArrayList<String> words, String word) {
        for (int i = 0; i < word.length(); i++) {
            Assert.assertTrue(words.get(i).toLowerCase().contains(word.toLowerCase()));
        }
    }

    public boolean correctionExists() {
        if (driver.findElement(didYouMean) != null) {
            return true;
        }
        return false;
    }
}


