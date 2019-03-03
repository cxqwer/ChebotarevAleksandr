package homeworks.hw7;

import base.jdi.entities.User;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.ui.html.PageFactory;
import homeworks.hw4.enums.NatureElements;
import homeworks.hw7.enums.HeaderElements;
import homeworks.hw7.enums.MetalsAndColorsData;
import homeworks.hw7.enums.Vegetables;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static homeworks.hw4.enums.Colors.*;
import static homeworks.hw4.enums.Metals.*;
import static homeworks.hw4.enums.NatureElements.*;
import static homeworks.hw7.JdiSite.indexPage;
import static homeworks.hw7.JdiSite.metalsAndColorsPage;
import static homeworks.hw7.enums.Vegetables.*;

public class JdiPageTest {

    private static Vegetables[] SELECTED_VEGETABLES = {CUCUMBER, TOMATO};
    private static NatureElements[] SELECTED_NATURE_ELEMENTS = {WATER, FIRE};

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
        indexPage.openInHeader(HeaderElements.METALS_AND_COLORS);
        metalsAndColorsPage.checkIsOpen();
        metalsAndColorsPage.checkTitle(MetalsAndColorsData.TITLE);

        // 3 Fill form Metals & Colors
        metalsAndColorsPage.selectSummary(3, 8);
        metalsAndColorsPage.selectNatureElements(SELECTED_NATURE_ELEMENTS);
        metalsAndColorsPage.selectColor(RED);
        metalsAndColorsPage.selectMetal(SELEN);
        metalsAndColorsPage.clickVegetable(VEGETABLES);
        metalsAndColorsPage.selectVegetables(SELECTED_VEGETABLES);
        metalsAndColorsPage.clickSubmit();

        // 4 Check results sections
        metalsAndColorsPage.checkResult(11, RED, SELEN, SELECTED_VEGETABLES, SELECTED_NATURE_ELEMENTS);
    }
}
