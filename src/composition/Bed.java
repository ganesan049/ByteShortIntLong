package composition;

public class Bed {
    private final String style;
    private final int pillows;
    private final int height;
    private final int quilt;
    private final int sheets;

    public Bed(String style, int pillows, int height, int quilt, int sheets) {
        this.style = style;
        this.pillows = pillows;
        this.height = height;
        this.quilt = quilt;
        this.sheets = sheets;
    }
    public void make(){
        System.out.println("Bed -> Making | ");
    }

    public String getStyle() {
        return style;
    }

    public int getPillows() {
        return pillows;
    }

    public int getHeight() {
        return height;
    }

    public int getQuilt() {
        return quilt;
    }

    public int getSheets() {
        return sheets;
    }
}
