package DSA.Bitwise;

public class GFG {

  public static void main(String[] args) {
    System.out.println(addOne(2));
  }

  private static int addOne(int i) {
//    return -(~i);
    int m =1;
    while((i&m) >= 1){
      i = i ^ m;
      m <<= 1;
    }
    i = i ^ m;
    return i;
  }
}
