package homeworks.hw4;

import com.codeborne.selenide.SelenideElement;
import homeworks.hw4.enums.SliderData;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.actions;
import static org.testng.Assert.assertTrue;

public class SelenideSliderPage {

    @FindBy(css = "div.uui-main-container.page-inside div.main-content div form div:nth-child(4) div:nth-child(2)  div a:nth-child(1)")
    private SelenideElement leftSlider;

    @FindBy(css = "div.uui-main-container.page-inside div.main-content div form div:nth-child(4) div:nth-child(2)  div a:nth-child(3)")
    private SelenideElement rightSlider;

    @FindBy(css = "[class='panel-body-list logs']")
    private SelenideElement logs;

    @FindBy(css = "[class='uui-slider blue range ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']")
    private SelenideElement slider;

    //Cast, because  slider has bugs!
    public void moveSlidersBoundryPosition(int left, int right) {
        double step = slider.getSize().width * 0.01013;
        if (left > 0 && right > 0) {
            moveRightSlider((int) (step * right));
            moveLeftSlider((int) (step * left));
        } else if (left < 0 && right < 0) {
            moveLeftSlider((int) (step * left));
            moveRightSlider((int) (step * right));
        } else {
            if (left != 0) {
                moveLeftSlider((int) (step * left));
            }
            if (right != 0) {
                moveRightSlider((int) (step * right));
            }
        }
    }

    public void moveLeftSlider(int set) {
        actions().clickAndHold(leftSlider).moveByOffset(set, 0).release().build().perform();
    }

    public void moveRightSlider(int set) {
        actions().clickAndHold(rightSlider).moveByOffset(set, 0).release().build().perform();
    }

    public void chekFromAndToInLogs(SliderData from, SliderData to) {
        List<String> logMessages = logs.$$("li").texts();
        String actualFrom = null;
        String actualTo = null;
        for (String massage : logMessages) {
            if (massage.contains("(To)")) {
                actualTo = massage.substring(9);
                break;
            }
        }
        for (String massage : logMessages) {
            if (massage.contains("(From)")) {
                actualFrom = massage.substring(9);
                break;
            }
        }
        assertTrue(actualFrom.contains(from.toString()));
        assertTrue(actualTo.contains(to.toString()));
    }
}
