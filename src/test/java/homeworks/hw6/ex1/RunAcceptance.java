package homeworks.hw6.ex1;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = "src/test/java/resources/hw6/ex1",
        glue = "src/test/java/homeworks/hw6/ex1/Steps"

)
public class RunAcceptance extends AbstractTestNGCucumberTests {
    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = Browsers.CHROME;
        Configuration.startMaximized = true;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
    }
}
