package DSA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxProdArr {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(){{
            add(-1);
            add(-2);
            add(-3);
        }};
        bySliding(list);

}

    private static void bySliding(List<Integer> list) {
        int maxProd = Collections.max(list);
        int currMax = 1;
        int currMin = 1;
        for(int i=0;i<list.size();i++){
            if(list.get(i) == 0){
                currMax = 1;
                currMin = 1;
                continue;
            }
            int tmpMax = currMax*list.get(i);
            currMax = Math.max(currMax,Math.max(tmpMax,currMin*list.get(i)));
            currMin = Math.min(currMin,Math.min(tmpMax,currMin*list.get(i)));
            maxProd = Math.max(currMax,Math.max(maxProd,currMin));
        }

        System.out.println(maxProd);
    }
    }
