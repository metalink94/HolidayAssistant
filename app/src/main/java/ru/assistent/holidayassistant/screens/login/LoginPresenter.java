package ru.assistent.holidayassistant.screens.login;

import ru.assistent.holidayassistant.R;
import ru.assistent.holidayassistant.utils.ViewPresenter;

/**
 * Created by Денис on 16.08.2017.
 */

public class LoginPresenter extends ViewPresenter<LoginView> {

    public LoginPresenter(LoginView view) {
        setView(view);
    }

    public void onLoginButtonClick(String mLoginText, String mPasswordText) {
        if (mLoginText.isEmpty() || mLoginText.length() == 0) {
            getView().showToastMessage(R.string.need_login);
            return;
        }
        if (mPasswordText.isEmpty() || mPasswordText.length() == 0) {
            getView().showToastMessage(R.string.need_login);
            return;
        }
        getView().showDots();
    }
}
