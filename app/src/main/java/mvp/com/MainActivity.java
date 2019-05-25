package mvp.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;
import mvp.com.presenter.ILoginPresenter;
import mvp.com.presenter.LoginPresenter;
import mvp.com.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

    private EditText etEmail, etPassword;
    private Button btnLogin;
    private ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);

        loginPresenter = new LoginPresenter(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onLogin(etEmail.getText().toString(), etPassword.getText().toString());
            }
        });
    }


    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(MainActivity.this, message, Toast.LENGTH_SHORT, true).show();
    }

    @Override
    public void onLoginError(String message) {
        Toasty.error(MainActivity.this, message, Toast.LENGTH_SHORT, true).show();
    }
}