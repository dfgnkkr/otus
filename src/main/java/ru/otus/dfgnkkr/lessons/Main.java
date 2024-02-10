package ru.otus.dfgnkkr.lessons;

public class Main {
    public static void main(String[] args) {
        User[] users = new User[10];

        // заполняем массив
        for (int i = 0; i < 10; i++){
            String family = "family_" + i;
            String firstName = "name_" + i;
            String secondName = "otchestvo_" + i;
            String email = "email_" + i;
            int year = 1980 + i;
            users[i] = new User(family, firstName, secondName, year, email);
        }

        // выводим "пользователей старше 40 лет"
        for (User u : users) {
            int now = 2024;
            if (now - u.getYear() >= 40) {
                System.out.println("_________Инфа о пользователе__________");
                u.printUSerInfo();
            }
        }

//        Box box = new Box(1, "красный");
//        box.setOpen(true);
//        box.putItem("sdfsf");
    }
}