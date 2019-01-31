package homeworks.hw3.enums;

public enum HomePageData {
    INDEX_HTML_URL("https://epam.github.io/JDI/index.html"),
    HOME_PAGE_TITLE("Home Page");

    private String value;

    HomePageData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
