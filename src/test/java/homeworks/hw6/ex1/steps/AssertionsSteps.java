package homeworks.hw6.ex1.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import homeworks.hw3.enums.HomePageData;
import homeworks.hw3.enums.Users;
import homeworks.hw4.enums.Colors;
import homeworks.hw4.enums.Metals;
import homeworks.hw4.enums.NatureElements;
import homeworks.hw4.enums.SubcategoryData;
import homeworks.hw6.ex1.HomePageGherkin;
import homeworks.hw6.ex1.UserTablePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class AssertionsSteps {

    private HomePageGherkin homePage = page(HomePageGherkin.class);
    private UserTablePage differentElementsPage = page(UserTablePage.class);

    @Then("^The browser title should be '([^\"]*)'$")
    public void checkTitle(HomePageData homePageTitle) {
        homePage.checkTitle(homePageTitle);
    }

    @Then("^User's name should be '([^\"]*)'$")
    public void checkUser(Users user) {
        homePage.checkUserIsLoggined(user);
    }

    @And("^Interface should have all the necessary elements$")
    public void checkElements() {
        homePage.checkElementsExists();
    }

    @Then("^Service dropdown menu in header displays following options$")
    public void checkHeaderService(List<SubcategoryData> options) {
        homePage.checkHeaderService(options);
    }

    @Then("^Service dropdown in left section displays following options$")
    public void checkLeftService(List<SubcategoryData> options) {
        homePage.checkLeftService(options);
    }

    @Then("^Interface on Different elements page contains all needed elements$")
    public void checkDifferentElements() {
        differentElementsPage.checkCheckboxesAndRadios();
    }

    @And("^There is a Right section$")
    public void checkRightSection() {
        differentElementsPage.checkRightSection();
    }

    @And("^There is a Left section$")
    public void checkLeftSection() {
        differentElementsPage.checkLeftSection();
    }

    @Then("^Nature elements are true on log:$")
    public void checkTrueWaterInLog(List <NatureElements> natureElements) {
        differentElementsPage.checkCheckboxInLog(natureElements, true);
    }

    @Then("^Radio button '([^\"]*)' is correct on log$")
    public void checkRadioInLog(Metals metal) {
        differentElementsPage.checkRadioInLog(metal);
    }

    @Then("^Color '([^\"]*)' is correct on log$")
    public void checkColorOnLog(Colors color) {
        differentElementsPage.checkSelectedColor(color);
    }

    @Then("^Nature elements are false on log:$")
    public void checkFalseWaterInLog(List <NatureElements> natureElements) {
        differentElementsPage.checkCheckboxInLog(natureElements, false);
    }

}