import java.util.Comparator;

public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        if (user1.getLastName().compareTo(user2.getLastName()) != 0) {
            return user1.getLastName().compareTo(user2.getLastName());
        } else {
            return user1.getFirstName().compareTo(user2.getFirstName());
        }
    }
}
