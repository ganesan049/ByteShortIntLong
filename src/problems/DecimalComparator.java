package problems;

public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double n1, double n2) {
        double s1 = Math.signum(n1);
        double s2 = Math.signum(n2);
        if (s1 != s2) {
            return false;
        }
        s1 = Math.abs(n1);
        s2 = Math.abs(n2);
        int rs1 = (int) (s1 * 1000);
        int rs2 = (int) (s2 * 1000);
        return rs1 == rs2;
    }
}
