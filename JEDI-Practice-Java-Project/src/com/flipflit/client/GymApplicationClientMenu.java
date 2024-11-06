package com.flipflit.client;

import com.flipflit.bean.Role;

import java.util.Scanner;

public class GymApplicationClientMenu {

    public static Scanner scanner = new Scanner(System.in);
    private static GymAdminMenu adminClient = new GymAdminMenu();
    private static GymCustomerMenu customerClient = new GymCustomerMenu();
    private static GymOwnerMenu gymOwnerClient = new GymOwnerMenu();

    private static void mainPage(){
        System.out.println("1. Login\n2. Registration\n3. Update Password \n4. Exit");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                registration();
                break;
            case 3:
                updatePassword();
                break;
            case 4:
                System.out.println("Exit");
                return;
            default:
                System.out.println("INVALID_CHOICE_ERROR");
                break;
        }
        mainPage();
    }

    private static void login(){
            System.out.println("Enter your UserName");
            String userName = scanner.next();

            System.out.println("Enter your Passkey");
            String password = scanner.next();

            System.out.println("Enter your Role");
            Role role = Role.valueOf(scanner.next().toUpperCase());

            switch (role) {
                case ADMIN:
                    adminClient.adminLogin(userName, password);
                    break;
                case OWNER:
                    gymOwnerClient.gymOwnerLogin(userName, password);
                    break;
                case CUSTOMER:
                    customerClient.customerLogin(userName, password);
                    break;
                default:
                    System.out.println("INVALID_CHOICE_ERROR");
                    break;
            }
    }

    private static void registration(){
            System.out.println("Enter your role");
            Role role = Role.valueOf(scanner.next().toUpperCase());

            switch (role) {
                case ADMIN:
                    System.out.println("Admin is already registered");
                    mainPage();
                    break;
                case CUSTOMER:
                    customerClient.register();
                    break;
                case OWNER:
                    gymOwnerClient.register();
                    break;
                default:
                    System.out.println("INVALID_CHOICE_ERROR");
                    break;
            }
    }
    
    private static void updatePassword(){
        System.out.println("Updating password...");
    }

    public static void main(String[] args) {
        System.out.println("WELCOME TO FLIPFIT");
        mainPage();
    }
}
