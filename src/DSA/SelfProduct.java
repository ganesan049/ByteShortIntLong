package DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelfProduct {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(1,2,3,4);
//        byBruteForce(data);
        byPrefixSuffix(data);
    }

    private static void byPrefixSuffix(List<Integer> data) {
        List<Integer> result = new ArrayList<>();
        int prefix = 1;
        for(int i=0;i<data.size();i++){
            result.add(prefix);
            prefix*=data.get(i);
        }
        int postfix = 1;
        for(int i=data.size()-1;i>=0;i--){
            result.set(i,result.get(i)*postfix);
            postfix*=data.get(i);
        }
        System.out.println(result);
    }

    private static void byBruteForce(List<Integer> data) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<data.size();i++){
            int count = 0;
            int product = 1;
            while (count < data.size()){
                if(data.get(count) != data.get(i)){
                    product *= data.get(count);
                }
                count++;
            }
            result.add(product);
        }
        System.out.println(result);
    }
}
