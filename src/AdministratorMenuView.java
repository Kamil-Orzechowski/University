import java.util.Scanner;

public  class AdministratorMenuView extends SystemMenuView {
    public void initialize() {
        System.out.println("MENU ADMINISTRATORA");
        AdministratorMenuItem[] values = AdministratorMenuItem.values();
        for (AdministratorMenuItem item: values) {
            System.out.println(item.getNr()+" - "+item.getTranslated());
        }
        System.out.println("Twój wybór: ");
        Scanner scanner = new Scanner(System.in);
        int nr = scanner.nextInt();
        AdministratorMenuItem menuItem = AdministratorMenuItem.ofNr(nr);
        if (menuItem == AdministratorMenuItem.USER_LIST) {
            System.out.println("lista użytkowników");
            initialize();
        }
    }
}
