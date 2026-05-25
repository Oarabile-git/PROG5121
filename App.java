package com.mycompany.chatapplication;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("===== REGISTRATION =====");
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();
        System.out.print("Enter cellphone number: ");
        String cellphone = input.nextLine();
        Login login = new Login(username, password, cellphone,
        firstName, lastName);
        System.out.println(login.registerUser());
        System.out.println("\\n===== LOGIN =====");
        System.out.print("Enter username: ");
        String enteredUsername = input.nextLine();
        System.out.print("Enter password: ");
        String enteredPassword = input.nextLine();
        boolean loginSuccess = login.loginUser(enteredUsername,
        enteredPassword);
        System.out.println(login.returnLoginStatus(loginSuccess));
    
}
    
}
