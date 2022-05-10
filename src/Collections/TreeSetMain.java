package Collections;

import java.util.Map;

public class TreeSetMain {
    public static StockList stockList = new StockList();
    public static void main(String[] args) {
        StockItem temp = new StockItem("bread",0.86,100);
        stockList.addStock(temp);
        temp = new StockItem("cake",1.1,7);
        stockList.addStock(temp);
        temp = new StockItem("car",12.5,2);
        stockList.addStock(temp);
        temp = new StockItem("chair",15.86,100);
        stockList.addStock(temp);
        temp = new StockItem("cup",8.6,30);
        stockList.addStock(temp);temp = new StockItem("cup",80.6,300);
        stockList.addStock(temp);
        temp = new StockItem("door",6.12,12);
        stockList.addStock(temp);
        temp = new StockItem("bread",10.86,20);
        stockList.addStock(temp);
        System.out.println(stockList);
        Basket timsBasket = new Basket("Tim");
        sellItem(timsBasket,"car",1);
        System.out.println(timsBasket);
        sellItem(timsBasket,"car",1);
        System.out.println(timsBasket);
        sellItem(timsBasket,"car",1);
        sellItem(timsBasket,"cars",1);
        System.out.println(timsBasket);
        System.out.println(stockList);
    }
    public static int sellItem(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't have "+item);
            return 0;
        }
        if(stockList.reserveStock(item, quantity) != 0){
            return basket.addToBasket(stockItem,quantity);
        }
        return 0;
    }
    public static int removeItem(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't have "+item);
            return 0;
        }
        if(stockList.unreserveStock(item, quantity) != 0){
            return basket.removeFromBasket(stockItem,quantity);
        }
        return 0;
    }
    public static void checkOut(Basket basket){
        for(Map.Entry<StockItem,Integer> item:basket.Items().entrySet()){
            stockList.sellStock(item.getKey().getName(),item.getValue());
        }
        basket.clearBasket();
    }
}
