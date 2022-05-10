package DSA;

import java.util.Arrays;
import java.util.List;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,8,6,2,5,4,8,3,7);
//        byBruteForce(list);
        byPointer(list);
    }

    private static void byPointer(List<Integer> list) {
        int maxVol = -1;
        int l = 0,r =list.size()-1;
        while(l<r){
            maxVol = Math.max(maxVol,(r-l)*Math.min(list.get(l),list.get(r)));
            if(list.get(l) > list.get(r)){
                r-=1;
            }else{
                l+=1;
            }
        }
        System.out.println(maxVol);
    }

    private static void byBruteForce(List<Integer> list) {
        int maxVol = -1;
        for(int i=0;i<list.size()-1;i++){
        for(int j=i+1;j<list.size();j++){
            int vol = (j-i)*Math.min(list.get(i),list.get(j));
            if(vol > maxVol){
                maxVol = vol;
            }
        }
        }
        System.out.println(maxVol);
    }
}
