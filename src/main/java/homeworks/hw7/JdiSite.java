package homeworks.hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import homeworks.hw7.pages.IndexPageJdi;
import homeworks.hw7.pages.MetalsAndColorsPage;

@JSite("https://epam.github.io/JDI/")
public class JdiSite {
    public static IndexPageJdi indexPage;
    public static MetalsAndColorsPage metalsAndColorsPage;
}
