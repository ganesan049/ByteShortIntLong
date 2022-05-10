package DSA.Arrays;

public class MaxArea {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    public static int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int max = -1;
        while(l<r){
            int curVol = Math.min(height[l],height[r])*(r-l);
            max = Math.max(max,curVol);
            if(height[l]>height[r]){
                r-=1;
            }else{
                l+=1;
            }
        }
        return max;
    }
}
