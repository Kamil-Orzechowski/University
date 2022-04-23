import java.util.Scanner;

public class LoginForm {

    public void initialize() {
        FileUserRepository fileUserRepository = new FileUserRepository();
        String email = System.getenv("USER_EMAIL");
        String password = System.getenv("USER_PASSWORD");
        if (email == null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("========== EKRAN LOGOWANIA ==========");
            System.out.println("Podaj adres e-mail: ");
            email = scanner.nextLine();
            System.out.println("Podaj hasło: ");
            password = scanner.nextLine();
        }
        User user = fileUserRepository.findByEmailAndPassword(email, password);
        if (user != null) {
            System.out.println("Zalogowano jako: ");
            System.out.println(user);
            UserRole role = user.getRole();
            SystemMenuView systemMenuView = createMenuView(role);
            systemMenuView.initialize();
        } else {
            System.out.println("Dane nieprawidłowe, spróbuj ponownie");
            initialize();
        }
    }


    private SystemMenuView createMenuView(UserRole role) {
        if (role == UserRole.STUDENT) {
            return new StudentMenuView();
        } else if (role == UserRole.ADMINISTRATOR) {
            return new AdministratorMenuView();
        } else if (role == UserRole.TEACHER) {
            return new TeacherMenuView();
        } else {
            throw new RuntimeException("Not supported");
        }
    }

}
