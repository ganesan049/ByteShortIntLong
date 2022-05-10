package DSA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxSubArr {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(){{
           add(-2);
           add(1);
           add(-3);
           add(4);
           add(-1);
           add(2);
           add(1);
           add(-5);
           add(4);
        }};
//        byBruteForce(list);
        bySliding(list);
    }

    private static void bySliding(List<Integer> list) {
        int curSum = 0;
        int maxSub = list.get(0);
        for(int i=0;i<list.size();i++){
            if(curSum < 0){
                curSum = 0;
            }
            curSum+=list.get(i);
            maxSub = Math.max(maxSub,curSum);
        }
        System.out.println(maxSub);
    }

    private static void byBruteForce(List<Integer> list) {
        List<Integer> maxList = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            int tmpMax = list.get(i);
            maxList.add(tmpMax);
            for(int j=i+1;j<list.size();j++) {
                tmpMax += list.get(j);
                maxList.add(tmpMax);
            }
        }
        System.out.println(maxList);
        System.out.println(Collections.max(maxList));
    }
}
