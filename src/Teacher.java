public class Teacher extends User {
    private String academicDegree;

    public Teacher(String firstName, String lastName, String email, String password, String academicDegree) {
        super(firstName, lastName, email, password);
        this.academicDegree = academicDegree;
    }

    @Override
    public String toString() {
        return "Nauczyciel " + academicDegree;
    }
}
