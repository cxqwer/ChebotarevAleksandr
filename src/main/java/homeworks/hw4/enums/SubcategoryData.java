package homeworks.hw4.enums;

public enum SubcategoryData {
    SUPPORT("Support", 1),
    DATES("Dates", 2),
    COMPLEX_TABLE("Complex Table", 3),
    SIMPLE_TABLE("Simple Table", 4),
    USER_TABLE("User Table", 5),
    TABLE_PAGES("Table with pages", 6),
    DIFFERENT_ELEMENTS("Different elements", 7),
    PERFORMANCE("Performance", 8);

    private String value;
    private int number;

    SubcategoryData(String value, int number) {
        this.value = value;
        this.number = number;
    }

    @Override
    public String toString() {
        return value;
    }

    public int getNumber(){
        return  number;
    }
}
