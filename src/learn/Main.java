package learn;

public class Main {
    private int x = 2;
    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println(obj.x);
    }
    public void setX(int x){
        this.x = x;
    }
    public int getX(){
        return x;
    }
}
