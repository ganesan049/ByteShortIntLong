package DSA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(){{
            add(2);
            add(7);
            add(12);
            add(22);
        }};
        int result = 34;
//        byBruteForce(input,result);
        byPass(input,result);
    }

    private static void byPass(List<Integer> input, int result) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<input.size();i++){
            int neededKey = result - input.get(i);
            if(map.containsKey(neededKey)){
                System.out.println(map.get(neededKey)+" "+i);
                break;
            }else{
                map.put(input.get(i),i);
            }
        }
    }

    private static void byBruteForce(List<Integer> input, int result) {
        boolean output = false;
        for(int i=0;i<input.size()-1;i++){
            for(int j=i+1;j<input.size();j++) {
                if(input.get(i)+input.get(j) == result){
                    System.out.println(i+" "+j);
                    output = !output;
                    break;
                }
            }
            if(output){
                break;
            }
        }
    }
}
