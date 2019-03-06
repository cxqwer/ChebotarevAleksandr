package homeworks.hw7;

import base.jdi.entities.User;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import homeworks.hw7.entities.MetalsAndColorsElements;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static homeworks.hw7.JdiSite.indexPage;
import static homeworks.hw7.JdiSite.metalsAndColorsPage;
import static homeworks.hw7.enums.HeaderElements.METALS_AND_COLORS;
import static homeworks.hw7.enums.MetalsAndColorsData.TITLE;

public class JdiPageTest {

    private static MetalsAndColorsElements selectedElements = MetalsAndColorsElements.TEST_ELEMENTS;

    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(JdiSite.class);
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }

    @Test
    public void test() {
        // 1 Login on JDI site as User: Piter_Chailovskii
        indexPage.open();
        indexPage.login(User.PITER);
        indexPage.checkUserIsLogged(User.PITER);

        // 2 Open Metals&Colors page by Header menu
        indexPage.openInHeader(METALS_AND_COLORS);
        metalsAndColorsPage.checkIsOpen();
        metalsAndColorsPage.checkTitle(TITLE);

        // 3 Fill form Metals & Colors
        metalsAndColorsPage.fillForm(selectedElements);

        // 4 Check results sections
        metalsAndColorsPage.checkResult(selectedElements);
    }
}
