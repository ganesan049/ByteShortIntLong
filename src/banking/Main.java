package banking;

public class Main {
    public static void main(String[] args) {
//        Bank bank = new Bank("NAB");
//        bank.addBranch("Adelide");
//        bank.addCustomer("Adelide","Tim",50.05);
//        bank.addCustomer("Adelide","Mike",150.05);
//        bank.addCustomer("Adelide","Percy",250.05);
//        bank.addBranch("Sydey");
//        bank.addCustomer("Sydney","Bob",350.50);
//        bank.addCustomerTransaction("Adelide","Tim",400);
//        bank.listCustomer("Adelide",true);
        Bank bank = new Bank("National Australia Bank");

        bank.addBranch("Adelaide");

        bank.addCustomer("Adelaide", "Tim", 50.05);
        bank.addCustomer("Adelaide", "Mike", 175.34);
        bank.addCustomer("Adelaide", "Percy", 220.12);

        bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
        bank.addCustomerTransaction("Adelaide", "Mike", 1.65);

        bank.listCustomers("Adelaide", true);
    }
}
