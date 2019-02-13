package homeworks.hw5;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw4.enums.Colors;
import homeworks.hw4.enums.Metals;
import homeworks.hw4.enums.NatureElements;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static org.testng.Assert.assertEquals;

public class SupportPageAllure {
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

    @Step("Check elements page, it contains all checkboxes and radios")
    public void checkCheckboxesAndRadios(int numberCheckboxes, int numberRadios) {
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

    @Step("Assert that there is Right Section")
    public void checkRightSection() {
        rightSection.shouldHave(visible);
    }

    @Step("Assert that there is Left Section")
    public void checkLeftSection() {
        leftSection.shouldHave(visible);
    }

    @Step("Click on checkboxes")
    public void clickNatureElements(NatureElements selectedCheckbox) {
        checkboxes.findBy(text(selectedCheckbox.toString())).click();
    }

    @Step("Assert correct values of checkboxes in log rows")
    public void checkCheckboxInLog(NatureElements selectedCheckbox, boolean isOn) {
        logs.shouldHave(text(selectedCheckbox.toString() + ": condition changed to " + isOn));
    }

    @Step("Select radio")
    public void selectRadio(Metals radio) {
        radios.findBy(text(radio.toString())).click();
    }

    @Step("Assert correct value of radio in log rows")
    public void checkRadioInLog(Metals selectedRadio) {
        logs.shouldHave(text("metal: value changed to " + selectedRadio.toString()));
    }

    @Step("Select color in DropDown")
    public void selectDropdown(Colors selectedColor) {
        colorsSelect.click();
        colorsSelect.$(byText(selectedColor.toString())).click();
    }

    @Step("Assert correct value of color in log rows")
    public void checkSelectedColor(Colors selectedElement) {
        logs.shouldHave(text("Colors: value changed to " + selectedElement.toString()));
    }
}
