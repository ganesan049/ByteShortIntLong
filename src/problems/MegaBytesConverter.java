package problems;

public class MegaBytesConverter {
    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        int kbToMb = 1024;
        int mb = 0;
        int kb = 0;
        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
        } else {
            mb = kiloBytes / kbToMb;
            kb = kiloBytes % kbToMb;
            System.out.println(kiloBytes + " KB = " + mb + " MB and " + kb + " KB");
        }
    }
}
