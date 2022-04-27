import java.util.NoSuchElementException;

public enum AdministratorMenuItem {

    USER_LIST(1),
    EXIT(2);

    private int number;

    AdministratorMenuItem(int number) {
        this.number = number;
    }

    public String getTranslated() {
        switch (this) {
            case USER_LIST:
                return "lista użytkowników";
            case EXIT:
                return "wyjście z programu";
        }
        throw new RuntimeException("Not supported");
    }

    public static AdministratorMenuItem menuItemOfNumber(int number) {
        AdministratorMenuItem[] values = AdministratorMenuItem.values();
        for (AdministratorMenuItem administratorMenuItem : values) {
            if (administratorMenuItem.number == number) {
                return administratorMenuItem;
            }
        }
        throw new NoSuchElementException();
    }

    public int getNumber() {
        return number;
    }
}
