import java.util.List;

public class UserListView extends BaseView{

    public void initialize() {
        super.initialize();

        FileUserRepository fileUserRepository = new FileUserRepository();
        UserComparator comparator = new UserComparator();
        List<User> users = fileUserRepository.findAll();
        users.sort(comparator);

        System.out.println("Imię\t Nazwisko \t E-mail \t Funkcja");
        for (User user : users) {
            System.out.println(user.getFirstName() + "\t" + user.getLastName() + "\t"
                    + user.getEmail() + "\t" + user.getRole().getTranslated());
        }
    }

    @Override
    public String getTitle() {
        return "===== LISTA UŻYTKOWNIKÓW =====";
    }
}
