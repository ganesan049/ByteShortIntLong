package Collections;

public class StockItem implements Comparable<StockItem>{
    private final String name;
    private double price;
    private int quantityStock = 0;
    private int reserved = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int availableQuantity() {
        return quantityStock - reserved;
    }

    public void setPrice(double price) {
        if(price > 0.0){
            this.price = price;
        }
    }

    public int finalizeStock(int quantity){
        if(quantity <= reserved){
            quantityStock-=quantity;
            reserved-=quantity;
            return quantity;
        }
        return 0;
    }

    public void adjustStock(int quantityStock){
        int newQuantity = this.quantityStock + quantityStock;
        if(newQuantity >= 0){
            this.quantityStock = newQuantity;
        }
    }

    public int reserveStock(int quantity){
        if(quantity <= this.quantityStock){
            reserved+=quantity;
            return quantity;
        }
        return 0;
    }

    public int unreserveStock(int quantityStock){
        if(quantityStock <= reserved){
            reserved-=quantityStock;
            return quantityStock;
        }
        return 0;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof StockItem){
            return name.equals(((StockItem) obj).getName());
        }
        return false;
    }
    @Override
    public int hashCode(){
        return this.name.hashCode() + 57;
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering compareTo method");
        if(this == o){
            return 0;
        }
        if(o != null){
            return this.name.compareTo(o.getName());
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return name +
                ", price=" + price;
    }
}
