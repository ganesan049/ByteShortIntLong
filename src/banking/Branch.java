package banking;

import java.util.ArrayList;

public class Branch {
    private final ArrayList<Customer> customer;
    private final String name;

    public Branch(String name){
        this.name = name;
        this.customer = new ArrayList<Customer>();
    }

    public boolean newCustomer(String name,double amount){
        Customer custName = findCustomer(name);
        if(custName == null){
            this.customer.add(new Customer(name,amount));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String name, double amount){
        Customer customer = findCustomer(name);
        if(customer != null){
            customer.addTransaction(amount);
            return true;
        }else {
            return false;
        }
    }

    private Customer findCustomer(String name) {
        for(int i=0;(i<customer.size());i++){
            if(name.equals(customer.get(i).getName())){
                return customer.get(i);
            }
        }
        return null;
    }

    public ArrayList<Customer> getCustomer() {
        return customer;
    }

    public String getName() {
        return name;
    }
}
