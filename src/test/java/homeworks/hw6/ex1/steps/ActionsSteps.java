package homeworks.hw6.ex1.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import homeworks.hw3.enums.Users;
import homeworks.hw4.enums.Colors;
import homeworks.hw4.enums.Metals;
import homeworks.hw4.enums.NatureElements;
import homeworks.hw6.ex1.HomePageGherkin;
import homeworks.hw6.ex1.UserTablePage;

import static com.codeborne.selenide.Selenide.page;

public class ActionsSteps {

    private HomePageGherkin homePage = page(HomePageGherkin.class);
    private UserTablePage differentElementsPage = page(UserTablePage.class);

    @When("^I login as '([^\"]*)'$")
    public void login(Users user) {
        homePage.login(user);
    }

    @When("^I click on Service subcategory in the header$")
    public void clickHeaderService() {
        homePage.clickHeaderService();
    }

    @When("^I click on Service subcategory in the left section$")
    public void clickLeftService() {
        homePage.clickLeftService();
    }

    @When("^I open header menu Service -> Different Elements Page$")
    public void openDifferentElementsPage() {
        homePage.openDifferentElements();
    }

    @When("^I click checkboxes '([^\"]*)' and '([^\"]*)'$")
    public void selectCheckboxWater(NatureElements firstNature, NatureElements secondNature) {
        differentElementsPage.clickNatureElements(firstNature);
        differentElementsPage.clickNatureElements(secondNature);
    }

    @When("^I select radio button:'([^\"]*)'$")
    public void selectRadio(Metals metal) {
        differentElementsPage.selectRadio(metal);
    }

    @When("^I select '([^\"]*)' from the color selection dropdown$")
    public void selectColor(Colors color) {
        differentElementsPage.selectDropdown(color);
    }

    @When("^I unselect checkboxes '([^\"]*)'$")
    public void unselectCheckboxWater(NatureElements water) {
        differentElementsPage.clickNatureElements(water);
    }

    @And("^I unselect checkbox '([^\"]*)'$")
    public void unselectCheckboxWind(NatureElements wind) {
        differentElementsPage.clickNatureElements(wind);
    }

}