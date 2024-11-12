package com.flipfit.client;

import com.flipfit.bean.FlipFitAdmin;
import com.flipfit.bean.FlipFitGymCustomer;
import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.bean.FlipFitUser;
import com.flipfit.business.FlipFitAdminBusiness;
import com.flipfit.business.FlipFitGymCustomerBusiness;
import com.flipfit.business.FlipFitGymOwnerBusiness;
import com.flipfit.business.interfaces.IFlipFitAdmin;
import com.flipfit.dao.FlipFitAdminDAOImpl;
import com.flipfit.dao.FlipFitGymCustomerDAOImpl;
import com.flipfit.dao.FlipFitGymOwnerDAOImpl;
import com.flipfit.exceptions.ExceptionHandler;
import com.flipfit.exceptions.InvalidChoiceException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import com.flipfit.java17.DateAndTime;

/**
 * FlipFit Welcome Menu
 * @throws InvalidChoiceException
 */


public class GymFlipFitApplication {

    public static void main(String[] args) throws InvalidChoiceException {
        try {
            Scanner in = new Scanner(System.in);
            int choice = 0;

            do {
                System.out.println("Welcome To FlipFit");


                System.out.println("""
                        Select an option:
                         1 -> Login
                         2 -> Registration of Customer
                         3 -> Registration of Gym Owner
                         4 -> Exit
                        """);

                choice = in.nextInt();

                switch (choice) {
                    case 1: {
                        System.out.println(" Login ");
                        System.out.print("EmailId:> ");
                        String username = in.next();
                        System.out.print("Password:> ");
                        String password = in.next();
                        System.out.print("Enter your role:> Customer/Admin/GymOwner ");
                        String role = in.next();

                        switch (role) {
                            case "Customer": {
                                FlipFitUser gymCustomer = new FlipFitUser();
                                gymCustomer.setEmailID(username);
                                gymCustomer.setPassword(password);

                                FlipFitGymCustomerDAOImpl flipFitGymCustomerDAO = new FlipFitGymCustomerDAOImpl();
                                FlipFitGymCustomerBusiness GCBservice = new FlipFitGymCustomerBusiness(flipFitGymCustomerDAO);

                                gymCustomer = GCBservice.login(gymCustomer);
                                 if (gymCustomer == null)
                                     throw new IllegalStateException("Invalid credentials");
//
                                String currentDateTime = DateAndTime.getCurrentDateTime();
                                System.out.println("Login successful at: " + currentDateTime);

                                System.out.println("\nCustomer Menu");
                                GymFlipFitCustomerMenu.getFlipFitCustomerMenu(gymCustomer);
                                break;
                            }
                            case "Admin": {
                                FlipFitAdmin admin = new FlipFitAdmin();
                                admin.setEmailID(username);
                                admin.setPassword(password);

                                FlipFitAdminDAOImpl adminDAO = new FlipFitAdminDAOImpl();
                                IFlipFitAdmin flipFitAdmin = new FlipFitAdminBusiness(adminDAO);
                                boolean res = flipFitAdmin.adminLogin(admin);
                                if (res) {
                                    String currentDateTime = DateAndTime.getCurrentDateTime();
                                    System.out.println("Login successful at: " + currentDateTime);
                                    System.out.println("Admin Menu");
                                    GymFlipFitAdminMenu.getAdminView();
                                }
                                break;
                            }
                            case "GymOwner": {
                                FlipFitUser gymOwner = new FlipFitUser();
                                gymOwner.setEmailID(username);
                                gymOwner.setPassword(password);

                                FlipFitGymOwnerDAOImpl flipFitGymOwnerDAO = new FlipFitGymOwnerDAOImpl();
                                FlipFitGymOwnerBusiness GOBservice = new FlipFitGymOwnerBusiness(flipFitGymOwnerDAO);

                                gymOwner = GOBservice.login(gymOwner);
                                if (gymOwner == null)
                                    throw new IllegalStateException("Invalid credentials");
                                String currentDateTime = DateAndTime.getCurrentDateTime();
                                System.out.println("Login successful at: " + currentDateTime);
                                System.out.println(" GymOwner Menu ");
                                GymFlipFitOwnerMenu.getFlipFitOwnerView(gymOwner);
                                break;
                            }
                        }
                        break;
                    }

                    case 2: {
                        System.out.println("Registration of Gym Customer");

                        System.out.print("Enter your email address:> ");
                        String emailID = in.next();

                        System.out.print("Enter your phone number:> ");
                        String phoneNumber = in.next();

                        System.out.print("Enter your city:> ");
                        String city = in.next();

                        System.out.print("Enter your pin code:> ");
                        String pinCode = in.next();

                        System.out.print("Enter your password:> ");
                        String password = in.next();

                        System.out.print("Enter username:> ");
                        String username = in.next();

                        FlipFitUser gymCustomer = new FlipFitUser();
                        gymCustomer.setEmailID(emailID);
                        gymCustomer.setPassword(password);
                        gymCustomer.setPhoneNumber(phoneNumber);
                        gymCustomer.setUserName(username);

                        FlipFitGymCustomerDAOImpl flipFitGymCustomerDAO = new FlipFitGymCustomerDAOImpl();
                        FlipFitGymCustomerBusiness GCBservice = new FlipFitGymCustomerBusiness(flipFitGymCustomerDAO);

                        FlipFitGymCustomer flipFitGymCustomer = new FlipFitGymCustomer();
                        flipFitGymCustomer.setEmailID(emailID);
                        flipFitGymCustomer.setPassword(password);
                        flipFitGymCustomer.setPhoneNumber(phoneNumber);
                        flipFitGymCustomer.setUserName(username);
                        flipFitGymCustomer.setCity(city);
                        flipFitGymCustomer.setPinCode(pinCode);
                        flipFitGymCustomer.setRole(0);

                        flipFitGymCustomer = GCBservice.registerCustomer(flipFitGymCustomer);
                        gymCustomer.setUserID(flipFitGymCustomer.getUserId());
                        System.out.println("Registration completed for " + gymCustomer.getUserName());
                        System.out.println("Customer Menu");

                        GymFlipFitCustomerMenu.getFlipFitCustomerMenu(gymCustomer);
                        break;
                    }

                    case 3: {
                        System.out.println("Registration of Gym Owner");

                        System.out.print("Enter your email address:> ");
                        String emailID = in.next();

                        System.out.print("Enter your phone number:> ");
                        String phoneNumber = in.next();

                        System.out.print("Enter your city:> ");
                        String city = in.next();

                        System.out.print("Enter your pin code:> ");
                        String pinCode = in.next();

                        System.out.print("Enter your password:> ");
                        String password = in.next();

                        System.out.print("Enter username:> ");
                        String username = in.next();

                        System.out.print("Enter your panId:> " );
                        String panId = in.next();

                        System.out.print("Enter your gstNum:> ");
                        String gstNum = in.next();

                        System.out.print("Enter your aadharNumber:> ");
                        String aadharNumber = in.next();

                        FlipFitGymOwner flipFitOwner = new FlipFitGymOwner();
                        flipFitOwner.setEmailID(emailID);
                        flipFitOwner.setPassword(password);
                        flipFitOwner.setPhoneNumber(phoneNumber);
                        flipFitOwner.setCity(city);
                        flipFitOwner.setPinCode(pinCode);
                        flipFitOwner.setUserName(username);
                        flipFitOwner.setRole(1);
                        flipFitOwner.setGSTIN(gstNum);
                        flipFitOwner.setAadharNumber(aadharNumber);
                        flipFitOwner.setPanId(panId);
                        flipFitOwner.setIsApproved(false);

                        FlipFitGymOwnerDAOImpl flipFitGymOwnerDAO = new FlipFitGymOwnerDAOImpl();
                        FlipFitGymOwnerBusiness GOBservice = new FlipFitGymOwnerBusiness(flipFitGymOwnerDAO);

                        GOBservice.registerOwner(flipFitOwner);
                        System.out.println( "Successfully registered " + flipFitOwner.getUserName() );

                        break;
                    }

                    case 4: {
                        System.out.println("Exit");
                        return;
                    }

                    default: {
                        throw new InvalidChoiceException("Invalid choice entered");
                    }
                }
            }
            while (true);
        } catch(InvalidChoiceException e){ ExceptionHandler.InvalidChoiceMainMenu(e);}
    }
}

