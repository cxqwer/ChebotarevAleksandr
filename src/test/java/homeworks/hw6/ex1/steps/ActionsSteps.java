package homeworks.hw6.ex1.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import homeworks.hw3.enums.Users;
import homeworks.hw4.enums.Colors;
import homeworks.hw4.enums.Metals;
import homeworks.hw4.enums.NatureElements;
import homeworks.hw4.enums.SubcategoryData;
import homeworks.hw6.ex1.HomePageGherkin;
import homeworks.hw6.ex1.UserTablePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class ActionsSteps {

    private HomePageGherkin homePage = page(HomePageGherkin.class);
    private UserTablePage differentElementsPage = page(UserTablePage.class);

    @When("^I login as '([^\"]*)'$")
    public void login(Users user) {
        homePage.login(user);
    }

    @When("^I click on Service subcategory in the left section$")
    public void clickServiceInLeftSection() {
        homePage.clickLeftService();
    }

    @When("^I expand Service subcategory in the header menu$")
    public void expandServiceInHeader() {
        homePage.clickHeaderService();
    }

    @When("^I open '([^\"]*)' in Service menu of the header$")
    public void openPageInServiceOfHeader(SubcategoryData category) {
        homePage.openPageInServiceOfHeader(category);
    }

    @When("^I click nature elements:$")
    public void selectCheckboxWater(List<NatureElements> natureElements) {
        differentElementsPage.clickNatureElements(natureElements);
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
    public void unselectCheckboxWater(List <NatureElements> water) {
        differentElementsPage.clickNatureElements(water);
    }

    @And("^I unselect checkbox '([^\"]*)'$")
    public void unselectCheckboxWind(List <NatureElements> wind) {
        differentElementsPage.clickNatureElements(wind);
    }

    @And("^I click on Service subcategory in the header$")
    public void clickServiceInHeader() {
        homePage.clickHeaderService();
    }

}