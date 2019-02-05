package homeworks.hw4.enums;

public enum ServiceSubcategorysData {
    FIRST_SUBCATEGORY("Support"),
    SECOND_SUBCATEGORY("Dates"),
    THIRD_SUBCATEGORY("Complex Table"),
    FOURTH_SUBCATEGORY("Simple Table"),
    FIFTH_SUBCATEGORY("User Table"),
    SIXTH_SUBCATEGORY("Table with pages"),
    SEVENTH_SUBCATEGORY("Different elements"),
    EIGHTH_SUBCATEGORY("Performance");

    private String value;

    ServiceSubcategorysData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
