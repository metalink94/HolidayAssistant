package ru.assistent.holidayassistant.screens.registration;

import ru.assistent.holidayassistant.utils.IView;

/**
 * Created by Денис on 17.08.2017.
 */

interface RegistrationView extends IView {
    void checkFirstPage();

    void checkSecondPage();

    void showErrorToast(int message);

    void changeButtonText(int text);

    void changePage();

    void openProfileScreen();
}
