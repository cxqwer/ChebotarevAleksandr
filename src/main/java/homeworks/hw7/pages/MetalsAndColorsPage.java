package homeworks.hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.common.Button;
import homeworks.hw4.enums.Colors;
import homeworks.hw4.enums.Metals;
import homeworks.hw4.enums.NatureElements;
import homeworks.hw7.entities.MetalsAndColorsElements;
import homeworks.hw7.enums.MetalsAndColorsData;
import homeworks.hw7.enums.Vegetables;
import homeworks.hw7.forms.MetalsAndColorsForm;
import homeworks.hw7.sections.ResultPanel;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Url("metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    public static MetalsAndColorsForm elementsForm;
    public static ResultPanel resultPanel;

    @FindBy(css = "#submit-button")
    public Button submit;

    public void checkTitle(MetalsAndColorsData Title) {
        assertEquals(getTitle(), Title.toString());
    }

    public void checkIsOpen() {
        assertTrue(this.isOpened());
    }

    public void clickSubmit() {
        submit.click();
    }

    public void fillForm(MetalsAndColorsElements elements){
        elementsForm.fill(elements);
    }

    public void checkResult(int summary, Colors color, Metals metal, Vegetables[] vegetables, NatureElements[] elements) {
        resultPanel.checkResult(summary, color, metal, vegetables, elements);
    }

    public void clickVegetable(Vegetables vegetable){
        elementsForm.clickVegetable(vegetable);
    }
}