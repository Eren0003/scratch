package leetcode.Dynamic.tabulation;

import java.util.Arrays;

public class TargetSum {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1},3));
    }
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if((sum-target)%2 == 1 || target > sum){
            return 0;
        }
        int result = (sum-target)/2;
        int[] curr = new int[result+1];
        int[] prev = new int[result+1];
        curr[0] = 1;
        prev[0] = 1;
        for(int ind = 1 ; ind <= nums.length ; ind++){
            for(int t = 0 ; t <= result ; t++){
                int notTake = prev[t];
                int take = 0;
                if(t >= nums[ind-1]){
                    take = prev[t-(nums[ind-1])];
                }
                curr[t] = take+notTake;
            }
            prev = curr;
            curr = new int[result+1];
        }
        return prev[result];
    }
}
