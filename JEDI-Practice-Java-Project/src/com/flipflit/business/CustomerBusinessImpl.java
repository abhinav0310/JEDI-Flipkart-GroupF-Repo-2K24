package com.flipflit.business;

public class CustomerBusinessImpl implements CustomerBusiness {
    @Override
    public void createCustomer() {
        // TODO Auto-generated method stub
        System.out.println(" in the Create Customer Method");
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        // TODO Auto-generated method stub
        System.out.println("in The Delete Customer Method-->" +customerId);
        return true;
    }

    @Override
    public boolean updateCustomer(int customerId) {
        // TODO Auto-generated method stub
        System.out.println("int update Customer Method--->" +customerId);
        return true;
    }

    @Override
    public void listCustomer() {
        // TODO Auto-generated method stub
        System.out.println("in the List Customer Methods--->");
    }
}
