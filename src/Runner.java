import jdk.swing.interop.SwingInterOpUtils;

import java.util.List;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        FileUserRepository fileUserRepository = new FileUserRepository();
        List<User> users = fileUserRepository.findAll();
        System.out.println(users);

        test();

        LoginForm loginForm = new LoginForm();
        loginForm.initialize();
    }

    private static void test() {

        Student student1 = new Student("Witold", "Kowalski", "wk@o2.pl", "xxx", 22233);
        //System.out.println(student1);

        Teacher teacher1 = new Teacher("Jan", "Nowak", "sss", "xxx", "professor");
        //System.out.println(teacher1);

        Administrator administrator1 = new Administrator("Wiktoria", "Nowak", "wn@xx", "wn");

        FileUserRepository fileUserRepository = new FileUserRepository();
        fileUserRepository.insert(student1);
        fileUserRepository.insert(teacher1);
        fileUserRepository.insert(administrator1);

        //List<User> users = fileUserRepository.findAll();
        //System.out.println(users);
    }
}
