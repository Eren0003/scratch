package leetcode.Dynamic.tabulation;

import java.util.Arrays;

public class CanPartition {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,5,5,11}));
    }
    static boolean canPartition(int[] nums) {
        int sum = 0 ;
        for(int i : nums){
            sum += i;
        }
        if(sum%2 == 0){
            sum = sum/2;
        }else{
            return false;
        }
        boolean [] curr = new boolean[sum+1];
        boolean [] prev = new boolean[sum+1];
        prev[0] = true;
        for(int index = 1 ; index <= nums.length ; index++){
            for(int target = 0 ; target <= sum ; target++){
                boolean notTake = prev[target];
                boolean take = false;
                if(nums[index-1] <= target){
                    take = prev[target-nums[index-1]];
                }
                curr[target] = take || notTake;
            }
            prev = curr;
            curr = new boolean[prev.length];
        }
        return prev[curr.length-1];
    }
}
