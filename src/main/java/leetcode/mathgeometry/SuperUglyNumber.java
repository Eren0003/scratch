package leetcode.mathgeometry;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SuperUglyNumber {
    public static void main(String[] args) {
        System.out.println(superUglyNumber(5911,new int []{2,3,5,7}));
    }
     static int superUglyNumber(int n , int[] primes){
        if(n == 0 || primes.length == 0){
            return 0;
        }
        int[] index = new int[primes.length];
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1 ; i < n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0 ; j < primes.length ; j++){
                if(dp[index[j]]*primes[j] < min && dp[index[j]]*primes[j] > 0){
                        min = dp[index[j]] * primes[j];
                }
            }
            dp[i] = min ;
            for(int j = 0 ; j < primes.length ; j++){
                if(min == dp[index[j]]*primes[j]){
                    index[j] += 1;
                }
            }
        }
         System.out.println(Arrays.toString(dp));
        return dp[n-1];
     }
}
