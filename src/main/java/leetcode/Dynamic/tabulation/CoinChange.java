package leetcode.Dynamic.tabulation;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coin(new int[]{1,2,3},7));
    }
    static int coin(int[] coins ,int amount){
        int[] curr = new int[amount+1];
        int[] prev = new int[amount+1];
        for(int i = 0 ; i <= amount ; i++){
            if(i%coins[0] == 0){
                prev[i] = i/coins[0];
            }else{
                prev[i] = (int)1e9;
            }
        }
        for(int ind = 1 ; ind <= coins.length ; ind++){
            for(int target = 0 ; target <= amount ; target++){
                int take = prev[target];
                int notTake = (int)1e9;
                if(target >= coins[ind-1]){
                    notTake = curr[target-coins[ind-1]]+1;
                }
                curr[target] = Math.min(take,notTake);
            }
        }
        return curr[amount] < (int)1e9 ? curr[amount] : -1;
    }
}
