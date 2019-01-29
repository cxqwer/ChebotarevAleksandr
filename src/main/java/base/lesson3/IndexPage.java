package base.lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {
    private WebElement getPasswordField;
    private WebDriver driver;
    private WebDriver loginIcon;
    private WebElement userField;
    private WebElement SubmitButton;


    @FindBy(className = "user")
    private WebElement user;
    @FindBy(className = "password")
    private WebElement passwordField;


    @FindBy(className = "submit")
    private WebElement submitButton;


    public IndexPage(WebDriver driver) {
        this.driver = driver;
        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        userField = driver.findElement(By.cssSelector("[id='name']"));

        passwordField = driver.findElement(By.cssSelector("[id='password']"));
    }

    public void login(String name, String password) {
        user.sendKeys(name);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public void open() {
        driver.get("https://epam.github.io/JDI/index.html/");
    }

}
