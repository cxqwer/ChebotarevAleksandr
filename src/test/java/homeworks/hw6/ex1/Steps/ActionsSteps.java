package homeworks.hw6.ex1.Steps;

import cucumber.api.java.en.*;
import homeworks.hw3.enums.Users;
import homeworks.hw4.enums.*;
import homeworks.hw6.ex1.DifferentElemensPageGherkin;
import homeworks.hw6.ex1.HomePageGherkin;


import static com.codeborne.selenide.Selenide.page;

public class ActionsSteps {

    private HomePageGherkin homePage = page(HomePageGherkin.class);
    private DifferentElemensPageGherkin differentElementsPage = page(DifferentElemensPageGherkin.class);

    //3Perform login
    @When("^I login as '([^\"]*)'$")
    public void login(Users user) {
        homePage.login(user);
    }

    //6 Click on "Service" subcategory in the header and check that drop down contains options
    @When("^I click on Service subcategory in the header$")
    public void clickHeaderService() {
        homePage.clickHeaderService();
    }

    //7 Click on Service subcategory in the left section and check that drop down contains options
    @When("^I click on Service subcategory in the left section$")
    public void clickLeftService() {
        homePage.clickLeftService();
    }

    //8 Open through the header menu Service -> Different Elements Page
    @When("^I open header menu Service -> Different Elements Page$")
    public void openDifferentElementsPage() {
        homePage.openDifferentElements();
    }

    //12 Select checkboxes
    @When("^I click checkbox '([^\"]*)'$")
    public void selectCheckboxWater(NatureElements nature) {
        differentElementsPage.clickNatureElements(nature);
    }

    //14 Select radio
    @When("^I select radio button:'([^\"]*)'$")
    public void selectRadio(Metals metal) {
        differentElementsPage.selectRadio(metal);
    }

    //16 Select in dropdown
    @When("^I select '([^\"]*)' from the color selection dropdown$")
    public void selectColor(Colors color) {
        differentElementsPage.selectDropdown(color);
    }

    //18 Unselect checkboxes
    @When("^I unselect checkboxes '([^\"]*)'$")
    public void unselectCheckboxWater(NatureElements water) {
        differentElementsPage.clickNatureElements(water);
    }

    @And("^I unselect checkbox '([^\"]*)'$")
    public void unselectCheckboxWind(NatureElements wind) {
        differentElementsPage.clickNatureElements(wind);
    }

}