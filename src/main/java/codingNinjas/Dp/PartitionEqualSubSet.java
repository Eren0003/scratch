package codingNinjas.Dp;

public class PartitionEqualSubSet {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{2,1,2,2,2},5));
    }
    public static boolean canPartition(int[] arr, int n) {
        int totalSum = 0;
        for(int i : arr){
            totalSum += i;
        }
        if(totalSum%2 != 0){
            return false;
        }
        int target = totalSum/2;
        int[][] dp = new int[arr.length+1][target+1];
        return dfs(arr,0,target,dp);
    }
    static boolean dfs(int[] arr,int index ,int target,int[][] dp){
        if(target == 0){
            return true;
        }
        if(index == arr.length){
            return false;
        }if(dp[index][target] == -1){
            return false;
        }
        boolean take = dfs(arr,index+1,target,dp);
        if(take) {
            return true;
        }
        dp[index][target] = -1;
        if(target >= arr[index]) {
             boolean notTake = dfs(arr, index + 1, target - arr[index],dp);
             if(notTake){
                 return true;
             }
            dp[index][target] = -1;
        }
        return false;
    }
}
