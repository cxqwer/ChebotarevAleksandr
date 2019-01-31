package lessons.lesson4;

import base.SelenideBase;
import base.lesson4.SelenideIndexPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideSimpleTestWithPO extends SelenideBase {
    private SelenideIndexPage indexPage;

    @BeforeMethod
    public void initTest(){
        open("https://epam.github.io/JDI/index.html");
        indexPage = page(SelenideIndexPage.class);
    }

    @AfterMethod
    public void closeTest(){
        close();
    }

    @Test
    public void SimpleTest(){
        indexPage.login("epam", "1234");
    }
}