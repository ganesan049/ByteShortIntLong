package oops;

public class Point {
    private int x;
    private int y;

    public Point(){
        this(0,0);
    }

    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    public double distance(){
        return  this.distance(0,0);
    }

    public double distance(Point point){
        return this.distance(point.x,point.y);
    }

    public double distance(int xb,int yb){
        return Math.sqrt(((xb-this.x)*(xb-this.x))+((yb-this.y)*(yb-this.y)));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
