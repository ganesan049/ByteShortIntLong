package DSA;

import java.util.Arrays;
import java.util.List;

public class Stock {
    public static void main(String[] args) {
        List<Integer> stockData = Arrays.asList(7,1,5,3,6,4);
//        byBruteForce(stockData);
        byPointer(stockData);
    }

    private static void byPointer(List<Integer> stockData) {
        int maxGain = -1;
        int l=0;
        int r=1;
        while (r < stockData.size()){
            if(stockData.get(l) < stockData.get(r)){
                int gain = stockData.get(r) - stockData.get(l);
                maxGain = Math.max(gain,maxGain);
            }else {
                l=r;
            }
            r++;
        }
        System.out.println(maxGain);
    }

    private static void byBruteForce(List<Integer> stockData) {
        int maxGain = -1;
        for(int i=0;i<stockData.size()-1;i++){
            for(int j=i+1;j<stockData.size();j++) {
                int gain = stockData.get(j) - stockData.get(i);
                if(gain > maxGain){
                    maxGain = gain;
                }
            }
        }
        System.out.println(maxGain);
    }
}
