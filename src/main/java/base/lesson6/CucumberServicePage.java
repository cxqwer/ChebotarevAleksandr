package base.lesson6;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.AssertJUnit.assertEquals;

public class CucumberServicePage {

    public CucumberServicePage() {
        page(this);
    }

    @FindBy(css = "[id='user-name']")
    private SelenideElement userName;

    @FindBy(css = "[id='user-icon']")
    private SelenideElement loginIcon;

    @FindBy(css = "[id='name']")
    private SelenideElement userField;

    @FindBy(css = "[id='password']")
    private SelenideElement passwordField;

    @FindBy(css = "[id='login-button']")
    private SelenideElement submitButton;

    @Step
    @When("I'm on Home Page")
    public void open() {
        Selenide.open("https://epam.github.io/JDI/index.html");
    }

    @Step
    @Then("The browser title is (.+)")
    public void checkTitle(String title) {
        assertEquals(getWebDriver().getTitle(), title);
    }

    @Step
    @When("I login as user (.+) with password (.+)")
    public void login(String user, String password) {
        loginIcon.click();
        userField.sendKeys(user);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    @Step
    @Then("The user (.+) is displayed on the header")
    public void checkUserIsLogged(String user) {
        userName.shouldHave(visible, text(user));
    }


}