import java.util.NoSuchElementException;
import java.util.Scanner;

public class AdministratorMenuView extends SystemMenuView {
    @Override
    public void initialize() {
        AdministratorMenuItem[] values = AdministratorMenuItem.values();
        for (AdministratorMenuItem administratorMenuItem : values) {
            System.out.println(administratorMenuItem.getNumber() + " – " + administratorMenuItem.getTranslated());
        }

        try {Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            AdministratorMenuItem menuItem = AdministratorMenuItem.menuItemOfNumber(choice);
            switch (menuItem) {
                case USER_LIST -> {
                    UserListView userListView = new UserListView();
                    System.out.println(userListView.getTitle());
                    userListView.initialize();
                    System.out.println(getTitle());
                    initialize();
                }
                case EXIT -> {
                }
                default -> throw new RuntimeException("Not supported");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Niewłaściwy numer, spróbuj ponownie.");
            System.out.println(getTitle());
            initialize();
        }

    }

    @Override
    public String getTitle() {
        return "===== MENU ADMINISTRATORA =====";
    }
}
