package DSA.Arrays;

public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,3,5,3,6,4}));
    }
    public static int maxProfit(int[] prices) {
        int l=0;
        int profit = -1;
        for(int r=1;r<prices.length;r++){
            if(prices[r] > prices[l]){
                profit = Math.max(profit,prices[r] - prices[l]);
            }else{
                l=r;
            }
        }
        return profit;
    }
}
