package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import static java.lang.System.setProperty;

public class SeleniumBase {
    @BeforeSuite
    public void befoteSuite(){
            setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }
    @AfterSuite
    public  void afterSuite(){

    }
}
