package banking;

import java.util.ArrayList;

public class Bank {
    private final String name;
    private final ArrayList<Branch> branches;

    public Bank(String name){
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName){
        if(findBranch(branchName) == null){
            branches.add(new Branch(branchName));
            return true;
        }else {
            return false;
        }
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount){
        Branch branch = findBranch(branchName);
        if(branch != null){
            branch.newCustomer(customerName,initialAmount);
            return true;
        }else {
            return false;
        }
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double initialAmount){
        Branch branch = findBranch(branchName);
        if(branch != null){
            branch.addCustomerTransaction(customerName,initialAmount);
            return true;
        }else {
            return false;
        }
    }

    public boolean listCustomers(String branchName, boolean showTransaction){
        Branch branch = findBranch(branchName);
        if(branch != null){
            System.out.println("Customer detail for branch "+branch.getName());
            ArrayList<Customer> branchCustomer = branch.getCustomer();
            for(Customer customer:branchCustomer){
                System.out.println("Customer : "+customer.getName());
                if(showTransaction){
                    System.out.print("Transactions : ");
                    System.out.println(customer.getTransactions().toString());
                }
            }
            return true;
        }
        return false;
    }

    private Branch findBranch(String name) {
        for (Branch branch : branches) {
            if (name.equals(branch.getName())) {
                return branch;
            }
        }
        return null;
    }
}
