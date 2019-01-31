package homeworks.hw2.ex1;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestWithDataProvider {

    private String cssSelect = "[class='benefit-txt']";
    private WebDriver driver;
    static String URL = "https://epam.github.io/JDI/index.html";

    @DataProvider(parallel = true)
    private Object[][] dataProvider() {
        return new Object[][]{
                {0, "To include good practices\n" + "and ideas from successful\n" + "EPAM project"},
                {1, "To be flexible and\n" + "customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"}
        };
    }

    @BeforeSuite
    private void  beforeSuite(){
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(URL);
    }

    @AfterSuite
    public void afterSuite(){
        driver.close();
    }

    @Test(dataProvider = "dataProvider")
    public void test(int i, String text) {
        List<WebElement> webElements = driver.findElements(By.cssSelector(cssSelect));
        // TODO Idea warning
        assertEquals(text, webElements.get(i).getText());
    }
}
