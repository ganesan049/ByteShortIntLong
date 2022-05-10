package DSA.Tree;

public class NumberOf1Bits {
    public static void main(String[] args) {
        int n = 10001011;
        System.out.println(n);
        int c = 0;
        while(n > 0){
            c += n%2;
            n = n >> 1;
        }
        System.out.println(c);
    }
}
