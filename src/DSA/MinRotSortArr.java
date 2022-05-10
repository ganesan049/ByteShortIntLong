package DSA;

import java.util.ArrayList;
import java.util.List;

public class MinRotSortArr {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(){{
            add(4);
            add(5);
            add(6);
            add(0);
            add(1);
            add(2);
        }};
        bySliding(list);
    }

    private static void bySliding(List<Integer> list) {
        int l=0,r=list.size()-1;
        int min = list.get(0);
        while(l<r){
            if(list.get(l) < list.get(r)){
                min = Math.min(min,list.get(l));
                break;
            }
            int m = l+r/2;
            min = Math.min(min,list.get(m));
            if(list.get(l) <= list.get(m)){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        System.out.println(min);
    }
}
