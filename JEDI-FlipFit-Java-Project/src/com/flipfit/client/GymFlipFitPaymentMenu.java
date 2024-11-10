package com.flipfit.client;

import com.flipfit.bean.FlipFitPayments;
import com.flipfit.dao.FlipFitPaymentsDAOImpl;
import com.flipfit.dao.interfaces.IFlipFitPaymentsDAO;
import com.flipfit.exceptions.InvalidChoiceException;

import java.util.Scanner;

/**
 * FlipFit Payment Menu
 */


public class GymFlipFitPaymentMenu {
    private static final IFlipFitPaymentsDAO flipFitPaymentsDAO = new FlipFitPaymentsDAOImpl();

    public static FlipFitPayments getFlipFitPaymentMenu(int userId, int bookingID) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\nWe provide the following modes of payment:");
            System.out.println("        1. Credit Card");
            System.out.println("        2. Debit Card");
            System.out.println("        3. UPI");
            System.out.println("        4. NEFT/RTGS");
            System.out.print("Please enter your choice: ");
            int paymentChoice = sc.nextInt();

//            System.out.print("Enter Transaction ID:   ");
            String transactionId = "FFGSB"+(int)(Math.random()*10000);

            if(transactionId.startsWith("FFGSB")){
                FlipFitPayments flipFitPayment = new FlipFitPayments();
                flipFitPayment.setUserID(userId);
                flipFitPayment.setPaymentType(paymentChoice);
                flipFitPayment.setPaymentInfo(transactionId);
                flipFitPayment.setBookingID(bookingID);
                //flipFitPayment.setTransactionStatus(true);

                flipFitPaymentsDAO.setPaymentInfo(flipFitPayment);
                return flipFitPayment;
            } else {
                System.out.println("Invalid TransactionID. Please try again.");
            }
        }

    }
}
