package homeworks.hw4.enums;

// TODO This is Colors !
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
