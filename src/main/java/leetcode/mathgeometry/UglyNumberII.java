package leetcode.mathgeometry;

import java.util.Arrays;

public class UglyNumberII {
    public static void main(String[] args) {
        System.out.println(uglyNumber(11));
    }
    static int uglyNumber(int n) {
        int p2 = 0 ; int p3 = 0 ; int p5 = 0 ;
        int [] dp = new int[n];
        dp[0] = 1;
        for(int i = 1 ; i < n ; i++){
            dp[i] = Math.min(Math.min(dp[p2]*2,dp[p3]*3),dp[p5]*5);
            if(dp[p2]*2 == dp[i]){
                p2 += 1;
            }if(dp[p3]*3 == dp[i]){
                p3 += 1;
            }if(dp[p5]*5 == dp[i]){
                p5 += 1;
            }
        }
        return dp[n-1];
    }
}
