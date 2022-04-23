import java.util.Scanner;

public class LoginForm {

    public void initialize() {
        FileUserRepository fileUserRepository = new FileUserRepository();
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========== EKRAN LOGOWANIA ============");
        System.out.println("Podaj adres e-mail: ");
        String email = scanner.nextLine();
        System.out.println("Podaj hasło: ");
        String password = scanner.nextLine();

        User user = fileUserRepository.findByEmailAndPassword(email, password);
        if (user != null) {
            System.out.println("Zalogowano jako: " + user);
        } else {
            System.out.println("Dane nieprawidłowe, spróbuj ponownie.");
            initialize();
        }
    }
}
