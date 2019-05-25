package mvp.com.presenter;

import mvp.com.model.User;
import mvp.com.view.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        int code = user.isValidData();
        if (code == 201) {
            loginView.onLoginError("You must enter your email");
        } else if (code == 202) {
            loginView.onLoginError("You must enter valid email");
        } else if (code == 203) {
            loginView.onLoginError("Password length must be greater than 6");
        } else {
            loginView.onLoginSuccess("Login Success");
        }
    }
}