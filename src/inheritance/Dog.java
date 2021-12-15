package inheritance;

public class Dog extends Animal{
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;
    public Dog(){
        super();
    }
    public Dog(int brain, int body, int size, int weigth, String name) {
        super(brain, body, size, weigth, name);
    }
//    public void eat(){
//        System.out.println("Eat method inside Dog called");
//    }
}
