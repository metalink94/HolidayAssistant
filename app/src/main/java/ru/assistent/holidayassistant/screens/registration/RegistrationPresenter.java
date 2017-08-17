package ru.assistent.holidayassistant.screens.registration;

import ru.assistent.holidayassistant.R;
import ru.assistent.holidayassistant.models.RegistrationModel;
import ru.assistent.holidayassistant.utils.ViewPresenter;

/**
 * Created by Денис on 17.08.2017.
 */

public class RegistrationPresenter extends ViewPresenter<RegistrationView> {

    private RegistrationModel mModel;

    public RegistrationPresenter() {
        mModel = new RegistrationModel();
    }

    public void onAcceptButtonClick(int currentItem) {
        if (currentItem == 0) {
            getView().checkFirstPage();
        } else {
            getView().checkSecondPage();
        }
    }

    public void onCheckFirstPage(String login, String password, boolean correctPassword) {
        if (login == null || login.isEmpty()) {
            getView().showErrorToast(R.string.need_login);
            return;
        }
        if (password == null || password.isEmpty()) {
            getView().showErrorToast(R.string.need_password);
            return;
        }
        if (!correctPassword) {
            getView().showErrorToast(R.string.error_check_password);
            return;
        }
        mModel.setPrimaryInformation(login, password);
        getView().changePage();
    }

    public void onCheckSecondPage(String name, String surname, String city) {
       if (name == null || surname == null || city == null ||
               name.isEmpty() || surname.isEmpty() || city.isEmpty()) {
           getView().changeButtonText(R.string.skip);
       } else {
           mModel.setPersonalInformation(name, surname, city);
       }
    }
}
