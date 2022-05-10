package DSA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Duplicate {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(7,1,5,3,6,15);
        byBruteForce(data);
    }

    private static void byBruteForce(List<Integer> data) {
        Map<Integer,Integer> map = new HashMap<>();
        boolean result = false;
        for(int i=0;i<data.size();i++){
            int el = data.get(i);
            if(map.containsKey(el)){
                    result = true;
                    break;
            }else {
                map.put(el,1);
            }
        }
        System.out.println(result);
    }
}
