import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Simpletest {

    @BeforeClass
    public void beforeClass() {
        // setProperty();
    }

    @Test
    public void simpleTest() {
        //1
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String handle = driver.getWindowHandle();
        driver.switchTo().window(handle);

        //2 Navigate url
        String s = "https://epam.github.io/JDI/index.html";
        driver.navigate().to(s);

        //3
        assertEquals(driver.getTitle(), "Home Page");

        //4
//        driver.close();
    }

    @Test
    public void simpleTest1() {

    }
}
