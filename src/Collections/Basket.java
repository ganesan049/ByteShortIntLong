package Collections;

import java.util.*;

public class Basket {
    private final String name;
    private final Map<StockItem,Integer> list;
    public Basket(String name){
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int removeFromBasket(StockItem item, int quantity){
        if((item!=null) && (quantity>0)){
            int inBasket = list.getOrDefault(item,0);
            int newQuantity = inBasket-quantity;
            if(newQuantity>0){
                list.put(item,newQuantity);
                return quantity;
            }else if(quantity == 0){
                list.remove(item);
                return quantity;
            }
        }
        return 0;
    }

    public void clearBasket(){
        this.list.clear();
    }

    public int addToBasket(StockItem item, int quantity){
        if((item != null) && (quantity > 0)){
            Integer inBasket = list.getOrDefault(item,0);
            list.put(item,inBasket+quantity);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem,Integer> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket "+name+" contains "+list.size()+" items\n";
        double totalCost = 0d;
        for(Map.Entry<StockItem,Integer> item : list.entrySet()){
            s += item.getKey()+". "+item.getValue()+" purchased\n";
            totalCost+=item.getKey().getPrice()*item.getValue();
        }
        return s+" totalcost "+totalCost;
    }
}
