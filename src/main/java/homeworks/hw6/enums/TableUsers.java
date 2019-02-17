package homeworks.hw6.enums;

public enum TableUsers {
    ROMAN(1, "Roman", "Wolverine"),
    SERGEY(2, "Sergey Ivan", "Spider Man"),
    VLADZIMIR(3, "Vladzimir", "Punisher"),
    HELEN(4, "Helen Bennett", "Captain America \n" + "some description"),
    YOSHI(5, "Yoshi Tannamuri", "Cyclope \n" + "some description"),
    GIOVANNI(6, "Giovanni Rovelli", "Hulk\n" + "some description");

    private int numberType;
    private String user;
    private String description;

    TableUsers(int numberType, String user, String description) {
        this.numberType = numberType;
        this.user = user;
        this.description = description;
    }

    public int getNumberType() {
        return numberType;
    }

    public String getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

    public String getNumberTypeString() {
        return Integer.toString(numberType);
    }
}

