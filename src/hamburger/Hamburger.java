package hamburger;

class HealthyBurger extends Hamburger{
    private String healthyExtra1Name;
    private double healthyExtra1Price;

    private String healthyExtra2Name;
    private double healthyExtra2Price;

    public HealthyBurger(String meat, double price) {
        super("Healthy", meat, price, "Brown rye");
    }

    @Override
    public double itemizeHamburger() {
        double hamburgerPrice =  super.itemizeHamburger();
        if(this.healthyExtra1Name != null){
            hamburgerPrice+=this.healthyExtra1Price;
            System.out.println("Added "+this.healthyExtra1Name+" for an extra "+this.healthyExtra1Price);
        }        if(this.healthyExtra2Name != null){
            hamburgerPrice+=this.healthyExtra2Price;
            System.out.println("Added "+this.healthyExtra2Name+" for an extra "+this.healthyExtra2Price);
        }
        return hamburgerPrice;
    }

    public void addHealthyAddition1(String name, double price){
        this.healthyExtra1Name = name;
        this.healthyExtra1Price = price;

    }

    public void addHealthyAddition2(String name, double price){
        this.healthyExtra2Name = name;
        this.healthyExtra2Price = price;
    }

}

public class Hamburger {
    private String name;
    private String meat;
    private double price;
    private String breadRollType;

    private String addition1Name;
    private double addition1Price;
    private String addition2Name;
    private double addition2Price;
    private String addition3Name;
    private double addition3Price;
    private String addition4Name;
    private double addition4Price;

    public Hamburger(String name, String meat, double price, String breadRollType) {
        this.name = name;
        this.meat = meat;
        this.price = price;
        this.breadRollType = breadRollType;
    }

    public double itemizeHamburger(){
        double hamburgerPrice = this.price;
        System.out.println(this.name+" hamburger on a "+this.breadRollType+" roll, "+meat+" meat price is "+this.price);
        if(this.addition1Name != null){
            System.out.println("Added "+this.addition1Name+" for an extra "+this.addition1Price);
            hamburgerPrice+=this.addition1Price;
        }        if(this.addition2Name != null){
            System.out.println("Added "+this.addition2Name+" for an extra "+this.addition2Price);
            hamburgerPrice+=this.addition2Price;
        }        if(this.addition3Name != null){
            System.out.println("Added "+this.addition3Name+" for an extra "+this.addition3Price);
            hamburgerPrice+=this.addition3Price;
        }        if(this.addition4Name != null){
            System.out.println("Added "+this.addition4Name+" for an extra "+this.addition4Price);
            hamburgerPrice+=this.addition4Price;
        }
        
        return hamburgerPrice;
    }

    public void addHamburgerAddition1(String name, double price){
        this.addition1Name = name;
        this.addition1Price = price;
    }
    public void addHamburgerAddition2(String name, double price){
        this.addition2Name = name;
        this.addition2Price = price;
    }
    public void addHamburgerAddition3(String name, double price){
        this.addition3Name = name;
        this.addition3Price = price;
    }
    public void addHamburgerAddition4(String name, double price){
        this.addition4Name = name;
        this.addition4Price = price;
    }
}
