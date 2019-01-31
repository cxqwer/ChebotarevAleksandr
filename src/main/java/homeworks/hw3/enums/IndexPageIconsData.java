package homeworks.hw3.enums;

public enum IndexPageIconsData {
    FIRST_TEXT_UNDER_ICONS("To include good practices\n" + "and ideas from successful\n" + "EPAM project"),
    SECOND_TEXT_UNDER_ICONS("To be flexible and\n" + "customizable"),
    THIRD_TEXT_UNDER_ICONS("To be multiplatform"),
    FOURTH_TEXT_UNDER_ICONS(
            "Already have good base\n" + "(about 20 internal and\n"
                    + "some external projects),\n" + "wish to get more…"
    );

    private String value;

    IndexPageIconsData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
