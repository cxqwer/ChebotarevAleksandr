package homeworks.hw4.ex1;

import base.SelenideBase;
import com.codeborne.selenide.Selenide;
import homeworks.hw3.enums.Users;
import homeworks.hw4.SelenideServicePage;
import homeworks.hw4.SelenideSupportPage;
import homeworks.hw4.enums.ServiceSubcategorysData;
import homeworks.hw4.enums.SupportData;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;
import static homeworks.hw3.enums.HomePageData.HOME_PAGE_TITLE;
import static homeworks.hw3.enums.HomePageData.INDEX_HTML_URL;

public class ServicePageTest extends SelenideBase {

    private SelenideServicePage servicePage;
    private SelenideSupportPage supportPage;
    private static final SupportData[] SELECTED_CHECKBOXES = new SupportData[]{
            SupportData.FIRST_CHECKBOXES,
            SupportData.THIRD_CHECKBOXES
    };

    @BeforeMethod
    public void beforeMethod() {
        //1 Open test site by URL
        Selenide.open(INDEX_HTML_URL.toString());
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
        servicePage.checkTitle(HOME_PAGE_TITLE);

        //3 Perform login
        servicePage.login(Users.PITER);

        //4 Assert User name in the left-top side of screen that user is loggined
        servicePage.checkUserIsLoggined(Users.PITER);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        servicePage.chekHeaderSecvice(ServiceSubcategorysData.values());

        //6 Click on Service subcategory in the left section and check that drop down contains options
        servicePage.chekLeftService(ServiceSubcategorysData.values());

        //7 Open through the header menu Service -> Different Elements Page
        servicePage.openHeaderDifferentElements(SupportData.TITLE);

        // 8 Check interface on Different elements page, it contains all needed elements
        supportPage.chekAllElements();

        // 9 Assert that there is Right Section
        supportPage.chekRightSection();

        // 10 Assert that there is Left Section
        supportPage.chekLeftSection();

        // 11 Select checkboxes
        supportPage.selectBoxes(SELECTED_CHECKBOXES);

        // 12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        supportPage.chekChekboxesTrueInLog(SELECTED_CHECKBOXES);

        // 13 Select radio
        supportPage.selectRadio(SupportData.FIRST_RADIO);

        // 14 Assert that for radiobutton there is a log row and value is corresponded to the status of
        supportPage.chekRadioLogValue(SupportData.FIRST_RADIO);

        // 15 Select in dropdown
        supportPage.selectDropdown(SupportData.FOURTH_DROPDOWN);

        // 16 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        supportPage.chekSelectedColor(SupportData.FOURTH_DROPDOWN);

        //17 Unselect checkboxes
        supportPage.selectBoxes(SELECTED_CHECKBOXES);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        supportPage.chekChekboxesFalseInLog(SELECTED_CHECKBOXES);
    }
}
