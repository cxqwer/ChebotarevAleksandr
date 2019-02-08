package homeworks.hw4.enums;

public enum DropdownElements {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    private String value;

    DropdownElements(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
