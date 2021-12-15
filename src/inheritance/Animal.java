package inheritance;

public class Animal {
    private int brain;
    private int body;
    private int size;
    private int weigth;
    private String name;
    public Animal(){}

    public void eat(){
        System.out.println("Eat method inside Animal called");
    }

    public int getBrain() {
        return brain;
    }

    public void setBrain(int brain) {
        this.brain = brain;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal(int brain, int body, int size, int weigth, String name) {
        this.brain = brain;
        this.body = body;
        this.size = size;
        this.weigth = weigth;
        this.name = name;
    }
}
