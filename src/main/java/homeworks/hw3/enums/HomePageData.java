package homeworks.hw3.enums;

import java.util.List;

public enum HomePageData {
    INDEX_HTML_URL("https://epam.github.io/JDI/index.html"),
    HOME_PAGE_TITLE("Home Page"),
    FIRST_ITEMS_TEXT("HOME"),
    SECOND_ITEMS_TEXT("CONTACT FORM"),
    THIRD_ITEMS_TEXT("SERVICE"),
    FOURTH_ITEMS_TEXT("METALS & COLORS"),
    FIRST_TEXT_UNDER_ICONS("To include good practices\n" + "and ideas from successful\n" + "EPAM project"),
    SECOND_TEXT_UNDER_ICONS("To be flexible and\n" + "customizable"),
    THIRD_TEXT_UNDER_ICONS("To be multiplatform"),
    FOURTH_TEXT_UNDER_ICONS("Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"),
    TITLE_ON_MAIN_HEADERS("EPAM FRAMEWORK WISHES…"),
    TEXT_ON_MAIN_HEADERS("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT " +
            "UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO " +
            "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
            "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),
    TEXT_OF_THE_SUB_HEADER("JDI GITHUB"),
    JDI_GITHUB_URL("https://github.com/epam/JDI");

    private String value;

    HomePageData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
