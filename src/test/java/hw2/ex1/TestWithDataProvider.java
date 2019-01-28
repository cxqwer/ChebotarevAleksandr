package hw2.ex1;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class TestWithDataProvider extends SeleniumBase {

    private String cssSelect = "[class='benefit-txt']";

    @DataProvider(parallel = true)
    private Object[][] dataProvider() {
        return new Object[][]{
                {0, "To include good practices\n" + "and ideas from successful\n" + "EPAM project"},
                {1, "To be flexible and\n" + "customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void test(int i, String text) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://epam.github.io/JDI/index.html";
        driver.navigate().to(url);

        List<WebElement> webElements = driver.findElements(By.cssSelector(cssSelect));
        assertTrue(webElements.get(i).isDisplayed());
        assertTrue(webElements.get(i).getText().equals(text));
        driver.close();
    }
}
