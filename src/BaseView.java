public abstract class BaseView {

    public void initialize() {
        System.out.println(getTitle());
    }

    public abstract String getTitle();

}
