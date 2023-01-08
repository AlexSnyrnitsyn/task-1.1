package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    private final static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        userService.createUsersTable();
        System.out.println("Table successfully created...");

        userService.saveUser("Миша", "Мишов", (byte) 20);
        userService.saveUser("Саша", "Сашов", (byte) 25);
        userService.saveUser("Стас", "Стасов", (byte) 30);
        userService.saveUser("Артем", "Артемов", (byte) 35);
        System.out.println("All users successfully saved...");

        userService.getAllUsers();
        System.out.println("All users successfully got...");

        userService.cleanUsersTable();
        System.out.println("Table successfully cleaned...");

        userService.dropUsersTable();
        System.out.println("Table successfully dropped...");
    }
}
