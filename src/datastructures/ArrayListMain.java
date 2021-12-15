package datastructures;

import java.util.ArrayList;

class GroceryList{
    private ArrayList<String> groceryList = new ArrayList<String>();
    public void addGroceryItems(String items){
        groceryList.add(items);
    }
    public void printGroceryList(){
        System.out.println("Length "+groceryList.size());
        System.out.println(groceryList.toString());
    }
    public void modifyGroceryItem(int position, String name){
        groceryList.set(position,name);
        System.out.println("Modified "+position);
    }
    public void removeGroceryItem(int position){
        String name = groceryList.get(position);
        groceryList.remove(position);
        System.out.println("Removed "+name);
    }
    public void findItem(String name){
        boolean present = groceryList.contains(name);
        int index = groceryList.indexOf(name);
        System.out.println("The "+name+" is "+present+" index "+index);
    }
}

public class ArrayListMain {
    public static void main(String[] args) {
        GroceryList groceryList = new GroceryList();
        groceryList.addGroceryItems("Apple");
        groceryList.addGroceryItems("Banana");
        groceryList.addGroceryItems("Cucumber");
        groceryList.printGroceryList();
        groceryList.modifyGroceryItem(2,"Cheese");
        groceryList.printGroceryList();
        groceryList.removeGroceryItem(1);
        groceryList.findItem("Cheese");
    }
}
