package codingNinjas.Dp;

import java.util.Arrays;

public class SubSetSumToK {
    public static void main(String[] args) {
        int[] arr = {9,8,1,3};
        int target = 4 ;
        System.out.println(sum(arr,target,3));
    }
    static boolean sum(int [] arr , int k,int n){
        int[][] dp = new int[arr.length+1][k+1];
        boolean result = dfs(arr,k,0,dp);
        for(int [] i : dp){
            System.out.println(Arrays.toString(i));
        }
        return  result ;
    }
    static boolean dfs(int[] arr,int target,int index,int[][] dp){
        if(index == arr.length){
            if(target == 0){
                return true;
            }
            dp[index][target] = -1;
            return false;
        }
        if(dp[index][target] == -1){
            return false;
        }
        if(target == 0){
            return true;
        }
        if(dfs(arr,target,index+1,dp)){
            return true;
        }
        if(target >= arr[index]) {
            if (dfs(arr, target - arr[index],index+1, dp)) {
                return true;
            }
        }
        return false;
    }
}
