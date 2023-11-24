package leetcode.Dynamic.memorization;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int [] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }
    static int coinChange(int[] num, int x) {
        int[][] dp = new int[num.length][x+1];
        Arrays.sort(num);
        for(int i = 0 ; i < num.length ; i++){
            Arrays.fill(dp[i],-1);
        }
        int result = minCoins(num,x,num.length-1,dp);
        if( result < (int)1e9){
            return result;
        }
        return -1;
    }
    static int minCoins(int[] coins,int target,int index,int[][] dp){
        if(index == 0){
            if(target%coins[index] == 0){
                dp[index][target] = target/coins[index];
                return target/coins[index];
            }
            dp[index][target] = (int) 1e9;
            return (int) 1e9;
        }
        if(dp[index][target] != -1){
            return dp[index][target] ;
        }
        int notTake = minCoins(coins,target,index-1,dp);
        int take =(int) 1e9;
        if(target >= coins[index]) {
            take = 1 + minCoins(coins, target - coins[index], index, dp);
        }
        dp[index][target] = Math.min(take,notTake);
        return dp[index][target];
    }
}
