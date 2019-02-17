package lessons.lesson6;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(features = "src/test/java/lessons/lesson6", glue = "base")
public class CucumberTestngRunner extends AbstractTestNGCucumberTests {
    @BeforeSuite
    public void beforeSuite(){
        Configuration.browser = "chrome";
    }
}
