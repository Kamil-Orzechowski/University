import java.util.List;

public class UserListView {
    public void initialize() {
        FileUserRepository fileUserRepository = new FileUserRepository();
        List<User> users = fileUserRepository.findAll();
    }
}
