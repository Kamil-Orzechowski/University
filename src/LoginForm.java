import java.util.Scanner;

public class LoginForm {

    public void initialize() {
        FileUserRepository fileUserRepository = new FileUserRepository();
        String email = System.getenv("USER_EMAIL");
        String password = System.getenv("USER_PASSWORD");
        if (email == null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("======== EKRAN LOGOWANIA ========");
            System.out.println("Podaj adres e-mail: ");
            email = scanner.nextLine();
            System.out.println("Podaj hasło: ");
            password = scanner.nextLine();
        }
        User loggedUser = fileUserRepository
                .findByEmailAndPassword(email, password);
        if (loggedUser != null) {
            System.out.println("Zalogowano jako:");
            System.out.println(loggedUser);
            UserRole role = loggedUser.getRole();
            SystemMenuView systemMenuView = createMenuView(role);
            systemMenuView.initialize();
        } else {
            System.out.println("Dane nieprawidłowe, spróbuj ponownie");
            initialize();
        }
    }

    private SystemMenuView createMenuView(UserRole role) {
        SystemMenuView systemMenuView;
        if (role == UserRole.ADMINISTRATOR) {
            systemMenuView = new AdministratorMenuView();
        } else if (role == UserRole.STUDENT) {
            systemMenuView = new StudentMenuView();
        } else if (role == UserRole.TEACHER) {
            systemMenuView = new TeacherMenuView();
        } else {
            throw new RuntimeException("Not supported");
        }
        return systemMenuView;
    }

}
