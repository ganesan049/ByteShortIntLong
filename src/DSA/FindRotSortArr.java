package DSA;

import java.util.ArrayList;
import java.util.List;

public class FindRotSortArr {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(){{
            add(4);
            add(5);
            add(6);
            add(0);
            add(1);
            add(2);
        }};
        int l=1,r=6;
        System.out.println((l+r)/2);
//        bySliding(list);
    }

    private static void bySliding(List<Integer> list) {
        int l=0,r=list.size()-1;
        int target = 1;
        boolean found = false;
        while(l<=r){
            int m = (l+r)/2;
            if(list.get(m) == target){
                System.out.println(m);
                found = true;
                break;
            }
            if(list.get(l) <= list.get(m)){
                if(target > list.get(m) || target < list.get(l)){
                    l=m+1;
                }else{
                    r=m-1;
                }
            }else{
                if(target < list.get(m) || target > list.get(r)){
                    r=m-1;
                }else{
                    l=m+1;
                }
            }
        }
        if(!found){
            System.out.println(-1);
        }
    }
}
