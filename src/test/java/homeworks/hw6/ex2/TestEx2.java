package homeworks.hw6.ex2;

import base.SelenideBase;
import com.codeborne.selenide.Selenide;
import homeworks.hw6.enums.TableUsers;
import homeworks.hw6.ex1.HomePageGherkin;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;
import static homeworks.hw3.enums.HomePageData.INDEX_HTML_URL;
import static homeworks.hw3.enums.Users.PITER;
import static homeworks.hw6.enums.TableUsers.ROMAN;
import static homeworks.hw6.enums.TableUsers.SERGEY;

public class TestEx2 extends SelenideBase {
    private HomePageGherkin homePage;
    private UserTablePage userTablePage;


    @BeforeMethod
    public void beforeMethod() {
        //1 Open test site by URL
        Selenide.open(INDEX_HTML_URL.toString());
        userTablePage = page(UserTablePage.class);
        homePage = page(HomePageGherkin.class);
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @Test
    void test(){
        homePage.login(PITER);

        homePage.checkUserIsLoggined(PITER);

        homePage.clickHeaderService();

        homePage.openUserTable();

        userTablePage.checkTitle("User Table");

        userTablePage.checkTypeDropdown(6);

        userTablePage.checkUserNames(6);

        userTablePage.checkImages(6);

        userTablePage.checkDescriptionTexts(6);

        userTablePage.checkCheckboxes(6);

        userTablePage.checkTableElements(TableUsers.values());

        userTablePage.clickVip(SERGEY);

        userTablePage.checkVipOnLog(true);

        userTablePage.clickOnDropdown(ROMAN);

        String [] values= {"Admin", "User", "Manager"};
        userTablePage.checkDroplistValues(ROMAN, values );
    }


}
