import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUserRepository implements UserRepository {
    @Override
    public void insert(User user) {
        List<User> users = findAll();
        users.add(user);
        File file = new File("users.bin");
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(users);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users;
        File file = new File("users.bin");
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            users = (List<User>) object;
        } catch (FileNotFoundException ex) {
            users = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        List<User> users = findAll();

        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    };

}
