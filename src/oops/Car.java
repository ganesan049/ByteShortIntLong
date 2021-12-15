package oops;

public class Car {

    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String color;
    public boolean available;

    public void setModel(String model){
        if(model == ("Carrera")){
            System.out.println("Yes");
        }
        this.model = model;
    }

    public String getModel(){
        return this.model;
    }

    public int getDoors(){
        return this.doors;
    }
}
