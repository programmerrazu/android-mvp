package mvp.com.view;

public interface ILoginView {
    void onLoginSuccess(String message);

    void onLoginError(String message);
}