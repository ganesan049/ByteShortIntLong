package DSA.Search;

import java.util.Arrays;

public class Binary {
  public static void main(String[] args) {
    System.out.println(binarySearch(new int[]{111,22,13,4,5},4));
  }

  private static boolean binarySearch(int[] ints, int i) {
    Arrays.sort(ints);
    int start = 0, end = ints.length - 1;
    while(start <= end){
      int midElem = start + ((end - start) / 2);
      if(ints[midElem] == i){
        return true;
      }else if(ints[midElem] < i){
        start = midElem+1;
      }else{
        end = midElem-1;
      }
    }
    return false;
  }
}
