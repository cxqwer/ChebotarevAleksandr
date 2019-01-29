package lessons.lesson3;

import base.SeleniumBase;
import base.lesson3.IndexPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleTestWithPO extends SeleniumBase {
    private IndexPage indexPage;
    private WebDriver driver;

    @BeforeMethod
    public void initTest() {
        indexPage = new IndexPage(driver);
    }

    @AfterMethod
    public void closeTest() {
        driver.close();
    }

    @Test
    public void SimpleTest() {
        indexPage.open();
        indexPage.login("Pavel", "1234");
    }

}
