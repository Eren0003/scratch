package leetcode.Dynamic.tabulation;

import java.util.Arrays;

public class countPrimes {
    public static void main(String[] args) {
        System.out.println(count(12));
    }
    static int count(int n){
        boolean[] dp = new boolean [n];
        int result = 0 ;
        for(int i = 2 ; i < n ; i++){
            if(!dp[i]) {
                result += 1;
                int temp = i+i ;
                while (temp < n){
                    dp[temp] = true;
                    temp = temp+i;
                }
            }
        }
        return result;
    }
}
