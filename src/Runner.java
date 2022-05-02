public class Runner {

    public static void main(String[] args) {
        test();
        LoginForm loginForm = new LoginForm();
        loginForm.initialize();
    }

    private static void test() {
        Student student1 = new Student("Jan", "Bobowski",
                "janek342@gmail.com", "Jan@13", 344421L);
        Teacher teacher1 = new Teacher("Małgorzata", "Kowalska",
                "kowalska@gmail.com", "malg@onE", "mgr");
        Administrator administrator1 = new Administrator("Witold", "Kowalski",
                "witek35@gmail.com", "Qwert@e9x3");
        Student student2 = new Student("Anna", "Anielewicz",
                "ania@gmail.com", "ania", 222L);
        Student student3 = new Student("Aldona", "Anielewicz",
                "aldona@gmail.com", "aldona", 223L);

//        UserRole role1 = UserRole.STUDENT;
//        UserRole role2 = UserRole.TEACHER;
//        UserRole role3 = UserRole.ADMINISTRATOR;

        FileUserRepository fileUserRepository = new FileUserRepository();
        fileUserRepository.insert(student1);
        fileUserRepository.insert(teacher1);
        fileUserRepository.insert(administrator1);
        fileUserRepository.insert(student2);
        fileUserRepository.insert(student3);
//        System.out.println(fileUserRepository.findAll());
    }

}
