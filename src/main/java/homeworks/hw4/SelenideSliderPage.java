package homeworks.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.actions;
import static org.testng.Assert.assertTrue;

public class SelenideSliderPage {

    // TODO It is completely prohibited to create locators in this way ! x2

    // TODO Once again, this locators should be improved
    @FindBy(css = "[class='ui-slider-handle ui-state-default ui-corner-all']")
    private ElementsCollection sliders;

    @FindBy(css = "[class='panel-body-list logs']")
    private SelenideElement logs;

    // TODO Once again, this locators should be improved
    @FindBy(css = "[class='uui-slider blue range ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']")
    private SelenideElement slider;

    // TODO Once again, this locators should be improved
    @FindBy(css = "[class='uui-slider blue range ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all'] > a:nth-child(3)")
    private SelenideElement rightSlider;

    // TODO Once again, this locators should be improved
    @FindBy(css = "[class='uui-slider blue range ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all'] > a:nth-child(1)")
    private SelenideElement leftSlider;


    // TODO You can't use such a this 'magic number' in your algorithm
    // TODO Take a look on Math.round
    // TODO Peace of hint: you can organise your algorithm around current values of slider, it will be easier.

    public void moveSlidersBoundryPosition(int left, int right) {
        assertCorrectValues(left, right);
        actions().clickAndHold(leftSlider).moveByOffset(-1000, 0).release().build().perform();
        actions().clickAndHold(rightSlider).moveByOffset(-1000, 0).release().build().perform();
        // TODO Pay attention, 100 != 100.0
        int step = (int) Math.round(slider.getSize().width / 100.0);
        int actualRightValue = Integer.valueOf(leftSlider.getText());
        int actualLeftValue = Integer.valueOf(leftSlider.getText());
        if (right == 100) {
            actions().clickAndHold(rightSlider).moveByOffset(1000, 0).release().build().perform();
        } else {
            while (actualRightValue != right) {
                actions().clickAndHold(rightSlider).moveByOffset(step, 0).release().build().perform();
                actualRightValue = Integer.valueOf(rightSlider.getText());
            }
        }
        if (left == 100) {
            actions().clickAndHold(leftSlider).moveByOffset(1000, 0).release().build().perform();
        } else {
            while (actualLeftValue != left) {
                actions().clickAndHold(leftSlider).moveByOffset(step, 0).release().build().perform();
                actualLeftValue = Integer.valueOf(leftSlider.getText());
            }
        }
    }

    public void checkFromAndToInLogs(int left, int right) {
        assertCorrectValues(left, right);
        assertTrue(logs.getText().contains("(To):" + right));
        assertTrue(logs.getText().contains("(From):" + left));
    }

    public void assertCorrectValues(int right, int left) {
        if (left < 0 || left > 100 || right < 0 || right > 100) {
            throw new IllegalArgumentException("The range of the sliders should be in [0, 100]");
        }
    }
}
