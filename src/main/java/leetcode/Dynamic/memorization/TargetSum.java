package leetcode.Dynamic.memorization;

import java.util.HashMap;

public class TargetSum {
    public static void main(String[] args) {
        int[]nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(targetSum(nums,target));
    }
    static int targetSum(int [] nums, int target){
        HashMap<String , Integer> map =new HashMap<>();
        return dfs(nums,target,0,0,map);
    }
    static int dfs(int[] nums , int target,int sum ,int index,HashMap<String,Integer> map){
        if(sum == target && index == nums.length){
            return 1;
        }
        if(index == nums.length){
            return 0 ;
        }
        String temp = index+","+sum;
        if(map.containsKey(temp)){
            return map.get(temp);
        }
        int counter = 0 ;
        counter += dfs(nums,target,sum+nums[index],index+1,map);
        counter += dfs(nums,target,sum-nums[index],index+1,map);
        map.put(temp,counter);
        return counter;
    }
}
