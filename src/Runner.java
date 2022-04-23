import jdk.swing.interop.SwingInterOpUtils;

import java.util.List;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm();
        loginForm.initialize();
    }

    private static void test() {
        System.out.println("test");

        Student student1 = new Student("Witold", "Kowalski", "wk@o2.pl", "xxx", 22233);
        System.out.println(student1);

        Teacher teacher1 = new Teacher("Jan", "Nowak", "sss", "xxx", "professor");
        System.out.println(teacher1);

        FileUserRepository fileUserRepository = new FileUserRepository();
        fileUserRepository.insert(student1);
        fileUserRepository.insert(teacher1);

        List<User> users = fileUserRepository.findAll();
        System.out.println(users);
    }
}
