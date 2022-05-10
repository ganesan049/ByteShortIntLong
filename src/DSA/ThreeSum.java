package DSA;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-1,0,1,2,-1,-4);
//        bruteForce(list);
        byPointerAndSort(list);
    }

    private static void byPointerAndSort(List<Integer> input) {
//        Collections.sort(input);
        System.out.println(input);
        List<List<Integer>> res = new ArrayList<>(new ArrayList<>());
        for(int i=0;i<input.size()-2;i++){
//            if(i > 0 && input.get(i-1) == input.get(i)){
//                continue;
//            }
            int find = -input.get(i);
            Map<Integer,Integer> map = new HashMap<>();
            for(int j=i+1;j<input.size();j++){
                int neededKey = find - input.get(j);
                if(map.containsKey(neededKey)){
                    System.out.println(i+" "+j+" "+map.get(neededKey));
                }else{
                    map.put(input.get(j),j);
                }
            }
        }
    }

    private static void bruteForce(List<Integer> input) {
        for(int i=0;i<input.size()-2;i++){
            for(int j=i+1;j<input.size()-1;j++) {
            for(int k=j+1;k<input.size();k++) {
                if (input.get(i) + input.get(j)+ input.get(k) == 0) {
                    System.out.println(input.get(i) +" "+ input.get(j)+" "+ input.get(k));
                }
            }
            }
        }
    }
}
