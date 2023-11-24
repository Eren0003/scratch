package leetcode.backTracking;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int [] nums = {1,2,3,5};
        System.out.println(canPartition(nums));
    }
    static boolean canPartition(int[] nums) {
        int sum = 0 ;
        for(int i : nums){
            sum += i ;
        }
        if(sum%2 != 0 ){
            return false;
        }
        if(dfs(nums,0,0,sum/2)){
            return true;
        }
        return false;
    }
    static boolean dfs(int[] nums, int index ,int sum,int target){
        if(index == nums.length){
            return false;
        }if(sum == target){
            return true;
        }
        return dfs(nums,index+1,sum+nums[index],target) || dfs(nums,index+1,sum,target);

    }

}
