package DSA.Matrix;

import java.util.*;

public class Rotate {
    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>(new ArrayList<>());
        input.add(Arrays.asList(5,1,9,11));
        input.add(Arrays.asList(2,4,8,10));
        input.add(Arrays.asList(13,3,6,7));
        input.add(Arrays.asList(15,14,12,16));
        rotate(input);
    }

    private static void rotate(List<List<Integer>> input) {
        int l=0,r=input.get(0).size()-1;
        while(l<r){
            for(int i=0;i<r-l;i++){
                int t=l,b=r;
                int topLeft = input.get(t).get(l+i);
                input.get(t).set(l+i,input.get(b-i).get(l));
                input.get(b-i).set(l,input.get(b).get(r-i));
                input.get(b).set(r-i,input.get(t+i).get(r));
                input.get(t+i).set(r,topLeft);
            }
            l+=1;r-=1;
        }
        for(List<Integer> val:input){
            System.out.println(val);
        }
    }
}
