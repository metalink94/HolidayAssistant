package ru.assistent.holidayassistant.screens.login;

import ru.assistent.holidayassistant.utils.IView;

/**
 * Created by Денис on 16.08.2017.
 */

interface LoginView extends IView {
    void showToastMessage(int message);

    void showDots();

    void openRegistrationActivty();
}
