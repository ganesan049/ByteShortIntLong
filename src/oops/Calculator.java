package oops;

public class Calculator {
    private final Floor floor;
    private final Carpet carpet;

    public Calculator(Floor floor, Carpet carpet) {
        this.floor = floor;
        this.carpet = carpet;
    }

    public double getTotalCost(){
        return this.carpet.getCost()*(this.floor.getArea());
    }
}
