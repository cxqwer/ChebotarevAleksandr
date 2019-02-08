package homeworks.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw4.enums.NatureElements;
import homeworks.hw4.enums.DropdownElements;
import homeworks.hw4.enums.Radios;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SelenideSupportPage {
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

    // TODO Once again, this locators should be improved
    @FindBy(css = "[class='uui-side-bar right-fix-panel mCustomScrollbar _mCS_2 mCS_no_scrollbar']")
    private SelenideElement rightSection;

    // TODO Once again, this locators should be improved
    @FindBy(css = "[class='uui-side-bar mCustomScrollbar _mCS_1 mCS_no_scrollbar']")
    private SelenideElement leftSection;

    @FindBy(css = "[class='panel-body-list logs']")
    private SelenideElement logs;

    @FindBy(css = "[class='colors']")
    private SelenideElement colorsSelect;

    // TODO Spelling, again... take a look on IDEA warning
    public void checkNumberСheckboxesAndRadio(int numberCheckboxes, int numberRadios) {
        assertEquals(checkboxes.size(), numberCheckboxes);
        for (SelenideElement element : checkboxes) {
            element.shouldHave(visible);
        }
        assertEquals(radios.size(), numberRadios);
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

    // TODO Pay attentions on this name and rename the reset of them with this approach
    public void selectNatureElements(NatureElements selectedCheckbox) {
        checkboxes.findBy(text(selectedCheckbox.toString())).click();
    }

    public void checkCheckboxInLog(NatureElements selectedCheckbox, boolean isOn) {
        // TODO You have to use Selenide assertions !
        assertTrue(logs.getText().contains(selectedCheckbox.toString() + ": condition changed to " + isOn));
    }

    public void selectRadio(Radios radio) {
        radios.findBy(text(radio.toString())).click();
    }

    public void checkRadioInLog(Radios selectedRadio) {
        // TODO You have to use Selenide assertions !
        assertTrue(logs.getText().contains("metal: value changed to " + selectedRadio.toString()));
    }

    public void selectDropdown(DropdownElements selectedColor) {
        colorsSelect.click();
        colorsSelect.$(byText(selectedColor.toString())).click();
    }

    public void checkSelectedColor(DropdownElements selectedElement) {
        // TODO You have to use Selenide assertions !
        assertTrue(logs.getText().contains("Colors: value changed to " + selectedElement.toString()));
    }
}
