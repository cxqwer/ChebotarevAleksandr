package homeworks.hw6.ex1;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw4.enums.Colors;
import homeworks.hw4.enums.Metals;
import homeworks.hw4.enums.NatureElements;
import homeworks.hw6.enums.UserTablePageInfo;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.*;

public class UserTablePage {

    @FindBy(css = "[class='label-checkbox']")
    private ElementsCollection checkboxes;

    @FindBy(css = "[class='label-radio']")
    private ElementsCollection radios;

    @FindBy(css = "[class='colors']")
    private SelenideElement dropDown;

    @FindBy(css = "[name='Default Button']")
    private SelenideElement defaultButton;

    @FindBy(css = "[value='Button']")
    private SelenideElement button;

    @FindBy(css = "[name='log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = "#mCSB_1_container")
    private SelenideElement leftSection;

    @FindBy(css = "[class='panel-body-list logs']")
    private SelenideElement logs;

    @FindBy(css = "[class='colors']")
    private SelenideElement colorsSelect;

    public void checkCheckboxesAndRadios() {
        assertEquals(checkboxes.size(), 4);
        for (SelenideElement element : checkboxes) {
            element.shouldHave(visible);
        }
        assertEquals(radios.size(), 4);
        for (SelenideElement element : radios) {
            element.shouldHave(visible);
        }
        dropDown.shouldHave(visible);
        defaultButton.shouldHave(visible);
        button.shouldHave(visible);
    }

    public void checkRightSection() {
        rightSection.shouldHave(visible);
    }

    public void checkLeftSection() {
        leftSection.shouldHave(visible);
    }

    public void clickNatureElements(List <NatureElements> natureElements ) {
        for(NatureElements element: natureElements){
            checkboxes.findBy(text(element.toString())).click();
        }
    }

    public void checkCheckboxInLog(List <NatureElements> natureElements, boolean isOn) {
        for (NatureElements element: natureElements){
            logs.shouldHave(text(element.toString() + ": condition changed to " + isOn));
        }
    }

    public void selectRadio(Metals radio) {
        radios.findBy(text(radio.toString())).click();
    }

    public void checkRadioInLog(Metals selectedRadio) {
        logs.shouldHave(text("metal: value changed to " + selectedRadio.toString()));
    }

    public void selectDropdown(Colors selectedColor) {
        colorsSelect.click();
        colorsSelect.$(byText(selectedColor.toString())).click();
    }

    public void checkSelectedColor(Colors selectedElement) {
        logs.shouldHave(text("Colors: value changed to " + selectedElement.toString()));
    }

    public void checkTitle(UserTablePageInfo title) {
        assertEquals(getWebDriver().getTitle(), title.toString());
    }
}
