package homeworks.hw4.enums;

public enum SubcategoryData {
    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    USER_TABLE("User Table"),
    TABLE_PAGES("Table with pages"),
    DIFFERENT("Different elements"),
    PERFORMANCE("Performance");

    private String value;

    SubcategoryData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
