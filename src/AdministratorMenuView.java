import java.util.NoSuchElementException;
import java.util.Scanner;

public class AdministratorMenuView extends SystemMenuView {
    @Override
    public void initialize() {
        super.initialize();

        AdministratorMenuItem[] values = AdministratorMenuItem.values();
        for (AdministratorMenuItem administratorMenuItem : values) {
            System.out.println(administratorMenuItem.getNumber() + " – " + administratorMenuItem.getTranslated());
        }

        try {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            AdministratorMenuItem menuItem = AdministratorMenuItem.menuItemOfNumber(choice);
            switch (menuItem) {
                case USER_LIST -> {
                    UserListView userListView = new UserListView();
                    userListView.initialize();
                    initialize();
                }
                case EXIT -> {
                }
                default -> throw new RuntimeException("Operacja nieobsługiwana.");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage() + " Spróbuj ponownie.");
            initialize();
        }

    }

    @Override
    public String getTitle() {
        return "===== MENU ADMINISTRATORA =====";
    }
}
