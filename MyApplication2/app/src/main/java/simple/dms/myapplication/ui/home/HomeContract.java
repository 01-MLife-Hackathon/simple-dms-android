package simple.dms.myapplication.ui.home;

public class HomeContract {
    public interface View {
        void postHome(String user, String home);
        void tokenError();
    }
    public interface Presenter {
        void postHome(String user, String home);
        void refreshToken(String user);
    }
}
