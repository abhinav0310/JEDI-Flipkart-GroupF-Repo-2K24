package com.flipflit.business;

public interface CustomerBusiness {
    public void createCustomer();
    public boolean deleteCustomer(int customerId);
    public boolean updateCustomer(int customerId);
    public void listCustomer();
}
