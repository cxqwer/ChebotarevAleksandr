package homeworks.hw6.enums;

public enum UsersTable {
    ROMAN(1, "Roman"),
    SERGEY(2, "Sergey Ivan"),
    VLADZIMIR(3, "Vladzimir"),
    HELEN(4, "Helen Bennett"),
    YOSHI(5, "Yoshi Tannamuri"),
    GIOVANNI(6, "Giovanni Rovelli");

    private int numberType;
    private String user;

    UsersTable(int numberType, String user) {
        this.numberType = numberType;
        this.user = user;
    }

    public int getNumberType() {
        return numberType;
    }

    public String getUser() {
        return user;
    }


}

