package ru.assistent.holidayassistant.models;

/**
 * Created by Денис on 17.08.2017.
 */

public class RegistrationModel {

    public String login;
    public String password;
    public String name;
    public String surname;
    public String city;

    public RegistrationModel() {

    }

    public void setPrimaryInformation(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void setPersonalInformation(String name, String surname, String city) {
        this.name = name;
        this.surname = surname;
        this.city = city;
    }
}
