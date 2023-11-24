package leetcode.mathgeometry;

import java.util.Arrays;

public class UglyNumberIII {
    public static void main(String[] args) {
        System.out.println(uglyNumberIII(5,2,11,13));
    }
    static int uglyNumberIII(int n ,int a,int b,int c ){
        int [] dp = new int[n+1];
        int a1 = 0, b1 = 0,c1 = 0 ;
        dp[0] = 1;
        for(int i = 1 ; i <= n ; i++){
            dp[i] = Math.min(Math.min(dp[a1]*a,dp[b1]*b),dp[c1]*c);
            if(dp[i] == dp[a1]*a){
                a1 += 1;
            }if(dp[i] == dp[b1]*b){
                b1 += 1;
            }if(dp[i] == dp[c1]*c){
                c1 += 1;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
