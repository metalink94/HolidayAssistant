package ru.assistent.holidayassistant.screens.login;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.assistent.holidayassistant.R;
import ru.assistent.holidayassistant.utils.BaseActivity;
import ru.assistent.holidayassistant.views.KitTextFieldView;
import ru.assistent.holidayassistant.views.ProgressButton;

/**
 * Created by Денис on 16.08.2017.
 */

public class LoginActivity extends BaseActivity implements LoginView {


    @BindView(R.id.login)
    KitTextFieldView mLogin;

    @BindView(R.id.password)
    KitTextFieldView mPassword;

    @BindView(R.id.login_btn)
    ProgressButton mButton;

    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mPresenter = new LoginPresenter(this);
    }

    @OnClick(R.id.login_btn)
    public void onLoginButtonClick() {
        mPresenter.onLoginButtonClick(mLogin.getText(), mPassword.getText());
    }

    @Override
    public void showToastMessage(int message) {
        showToast(message);
    }

    @Override
    public void showDots() {
        mButton.setDotsVisible();
    }
}
