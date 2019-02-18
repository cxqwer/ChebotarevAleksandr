package homeworks.hw6;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.close;

@CucumberOptions(
        features = {"src/test/java/resources/hw6/ex1", "src/test/java/resources/hw6/ex2"},
        glue = {"classpath:homeworks.hw6.ex1.steps", "classpath:homeworks.hw6.ex2.steps"}
)
public class RunAcceptance extends AbstractTestNGCucumberTests {
    @BeforeMethod
    public void beforeSuite() {
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
        Configuration.startMaximized = true;
    }

    @AfterMethod
    public void closeBrowser() {
        close();
    }

}

