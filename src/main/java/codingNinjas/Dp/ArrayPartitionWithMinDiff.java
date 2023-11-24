package codingNinjas.Dp;

public class ArrayPartitionWithMinDiff {
    public static void main(String[] args) {
        System.out.println(minSubsetSumDifference(new int[]{3,1,5,2,8},5));
    }
    public static int minSubsetSumDifference(int []arr, int n) {
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        boolean[][] dp = new boolean[arr.length][sum+1];
        for(int i = 0 ; i < arr.length ; i++){
            dp[i][0] = true;
        }
        dp[0][sum] = true;
        for(int ind = 1 ; ind < arr.length ; ind++){
            for(int target = 1 ; target <= sum ; target++){
                boolean notTaken = dp[ind-1][target];
                boolean taken = false;
                if(arr[ind] <= target){
                    taken = dp[ind-1][target - arr[ind]];
                }
                dp[ind][target] = taken || notTaken;
            }
        }
        int result = Integer.MAX_VALUE ;
        for(int i = 0 ; i <= sum ; i++){
            if(dp[arr.length-1][i]){
                result = Math.min(result,Math.abs(sum-(2*i)));
            }
        }
        return result;
    }
}
