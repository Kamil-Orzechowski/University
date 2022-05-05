import java.util.Comparator;

public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        int compareByLastName = user1.getLastName().compareTo(user2.getLastName());

        if (compareByLastName != 0) {
            return compareByLastName;
        } else {
            return user1.getFirstName().compareTo(user2.getFirstName());
        }
    }
}
