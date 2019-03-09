package homeworks.hw8.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import homeworks.hw8.entities.MetalsAndColorsElements;
import homeworks.hw8.enums.MetalsAndColorsData;
import homeworks.hw8.forms.MetalsAndColorsForm;
import homeworks.hw8.sections.ResultPanel;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Url("metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    public static MetalsAndColorsForm elementsForm;
    public static ResultPanel resultPanel;

    public void checkTitle(MetalsAndColorsData Title) {
        assertEquals(getTitle(), Title.toString());
    }

    public void checkIsOpen() {
        assertTrue(this.isOpened());
    }

    public void fillForm(MetalsAndColorsElements elements){
        elementsForm.fill(elements);
    }

    public void checkResult(MetalsAndColorsElements exactedElements) {
        resultPanel.checkResult(exactedElements);
    }

}