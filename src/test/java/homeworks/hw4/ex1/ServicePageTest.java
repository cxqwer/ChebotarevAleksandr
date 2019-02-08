package homeworks.hw4.ex1;

import base.SelenideBase;
import com.codeborne.selenide.Selenide;
import homeworks.hw3.enums.HomePageData;
import homeworks.hw3.enums.Users;
import homeworks.hw4.SelenideServicePage;
import homeworks.hw4.SelenideSupportPage;
import homeworks.hw4.enums.ServiceSubcategoryData;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static homeworks.hw3.enums.HomePageData.INDEX_HTML_URL;
import static homeworks.hw4.enums.NatureElements.*;
import static homeworks.hw4.enums.DropdownElements.*;
import static homeworks.hw4.enums.Radios.*;

public class ServicePageTest extends SelenideBase {

    private SelenideServicePage servicePage;
    private SelenideSupportPage supportPage;

    @BeforeMethod
    public void beforeMethod() {
        //1 Open test site by URL
        Selenide.open(INDEX_HTML_URL.toString());
        // TODO Nope, take a look on Selenide configurations
        getWebDriver().manage().window().maximize();
        servicePage = page(SelenideServicePage.class);
        supportPage = page(SelenideSupportPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @Test
    public void tests() {

        //2 Assert Browser title
        servicePage.checkTitle(HomePageData.HOME_PAGE_TITLE);

        //3 Perform login
        servicePage.login(Users.PITER);

        //4 Assert User name in the left-top side of screen that user is loggined
        servicePage.checkUserIsLogged(Users.PITER);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        servicePage.checkHeaderService(ServiceSubcategoryData.values());

        //6 Click on Service subcategory in the left section and check that drop down contains options
        servicePage.checkLeftService(ServiceSubcategoryData.values());

        //7 Open through the header menu Service -> Different Elements Page
        servicePage.openHeaderDifferentElements(HomePageData.DIFFERENT_ELEMENTS_PAGE_TITLE);

        // 8 Check interface on Different elements page, it contains all needed elements
        supportPage.checkNumberСheckboxesAndRadio(4, 4);

        // 9 Assert that there is Right Section
        supportPage.checkRightSection();

        // 10 Assert that there is Left Section
        supportPage.checkLeftSection();

        // 11 Select checkboxes
        supportPage.selectNatureElements(WATER);
        supportPage.selectNatureElements(WIND);

        // 12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        supportPage.checkCheckboxInLog(WATER, true);
        supportPage.checkCheckboxInLog(WIND, true);

        // 13 Select radio
        supportPage.selectRadio(GOLD);

        // 14 Assert that for radiobutton there is a log row and value is corresponded to the status of
        supportPage.checkRadioInLog(GOLD);

        // 15 Select in dropdown
        supportPage.selectDropdown(YELLOW);

        // 16 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        supportPage.checkSelectedColor(YELLOW);

        //17 Unselecte checkboxes
        supportPage.selectNatureElements(WATER);
        supportPage.selectNatureElements(WIND);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        supportPage.checkCheckboxInLog(WATER, false);
        supportPage.checkCheckboxInLog(WIND, false);
    }
}
