package leetcode.Dynamic.tabulation;


public class CountSubSetWithSumK {
    public static void main(String[] args) {
        System.out.println(findWays(new int[]{1,1,4,5},5));
    }
    public static int findWays(int num[], int tar) {
        int MOD = 1000000007;
        int[][] dp = new int[num.length][tar+1];
        for(int i = 0 ; i < num.length ; i++){
            dp[i][0] = 1;
        }
        if(num[0] <= tar){
            dp[0][num[0]] = 1;
        }
        for(int ind = 1 ; ind < num.length ; ind++){
            for(int target = 1 ; target <= tar ; target++){
                int take = dp[ind-1][target];
                int notTake = 0 ;
                if(num[ind] <= target){
                    notTake = dp[ind-1][target-num[ind]];
                }
                dp[ind][target] = (take+notTake)%MOD;
            }
        }
        return dp[num.length-1][tar];
    }
}
