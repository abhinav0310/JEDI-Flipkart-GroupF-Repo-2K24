package com.flipflit.application;

import com.flipflit.business.CustomerBusiness;
import com.flipflit.business.CustomerBusinessImpl;


public class FlipfitApplication {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // create the instance of the Interface & look of the methods

        CustomerBusiness service = new CustomerBusinessImpl();
        service.createCustomer();
        System.out.println("customer deleted by Id-->" + service.deleteCustomer(101));
        System.out.println("customer updated by id-->" + service.updateCustomer(101));
        service.listCustomer();
    }
}
