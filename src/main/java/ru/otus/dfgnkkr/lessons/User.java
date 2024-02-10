package ru.otus.dfgnkkr.lessons;

import java.util.Date;

public class User {
    /* фамилия */
    private String family;
    /* имя */
    private String firstName;
    /* отчество */
    private String secondName;
    /* год рождения */
    private int year;
    private String email;

    public User(String family, String firstName, String secondName, int year, String email) {
        this.family = family;
        this.firstName = firstName;
        this.secondName = secondName;
        this.year = year;
        this.email = email;
    }

    public void printUSerInfo(){
        System.out.println("ФИО: " + family + " " + firstName + " " + secondName);
        System.out.println("Дата рождения: " + year);
        System.out.println("email: " + email);
    }

    public String getFamily() {
        return family;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getYear() {
        return year;
    }

    public String getEmail() {
        return email;
    }
}
