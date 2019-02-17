package homeworks.hw6.ex1.Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import homeworks.hw3.enums.*;
import homeworks.hw4.enums.*;
import homeworks.hw6.ex1.DifferentElemensPageGherkin;
import homeworks.hw6.ex1.HomePageGherkin;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class AssertionsSteps {

    private HomePageGherkin homePage = page(HomePageGherkin.class);
    private DifferentElemensPageGherkin differentElementsPage = page(DifferentElemensPageGherkin.class);

    //2 Assert Browser title
    @Then("^The browser title should be '([^\"]*)'$")
    public void checkTitle(HomePageData homePageTitle) {
        homePage.checkTitle(homePageTitle);
    }

    //4 Assert User name in the right-top side of screen that user is loggined
    @Then("^User's name should be '([^\"]*)'$")
    public void checkUser(Users user) {
        homePage.checkUserIsLoggined(user);
    }

    //5 Check interface on Home page, it contains all needed elements.
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

    //9 Check interface on Different elements page, it contains all needed elements
    @Then("^Interface on Different elements page contains all needed elements$")
    public void checkDifferentElements() {
        differentElementsPage.checkCheckboxesAndRadios();
    }

    //10 Assert that there is Right Section
    @And("^There is a Right section$")
    public void checkRightSection() {
        differentElementsPage.checkRightSection();
    }

    //11 Assert that there is Left Section
    @And("^There is a Left section$")
    public void checkLeftSection() {
        differentElementsPage.checkLeftSection();
    }

    //13 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
    @Then("^Checkbox '([^\"]*)' is correct on log$")
    public void checkTrueWaterInLog(NatureElements water) {
        differentElementsPage.checkCheckboxInLog(water, true);
    }

    //15 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
    @Then("^Radio button '([^\"]*)' is correct on log$")
    public void checkRadioInLog(Metals metal) {
        differentElementsPage.checkRadioInLog(metal);
    }

    //17 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
    @Then("^Color '([^\"]*)' is correct on log$")
    public void checkColorOnLog(Colors color) {
        differentElementsPage.checkSelectedColor(color);
    }

    //19 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
    @Then("^Check checkbox '([^\"]*)' is unchecked$")
    public void checkFalseWaterInLog(NatureElements water) {
        differentElementsPage.checkCheckboxInLog(water, false);
    }

}