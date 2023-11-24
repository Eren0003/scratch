package leetcode.backTracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MatchStickToSquare {
    public static void main(String[] args) {
        System.out.println(canMatch(new int[]{2,2,2,2,2,6}));;
    }
    static boolean match(int[] matchsticks){
        int totalSum= 0;
        for (int matchstick : matchsticks) {
            totalSum += matchstick;
        }
        if(totalSum%4 != 0){
            return false;
        }
        return backTracking(matchsticks,totalSum/4,0,0,new HashSet<>(),4);
    }
    static boolean backTracking(int[] matchsticks, int target,int index, int sum ,Set<Integer> set ,int k){
        if(k == 0){
            return true;
        }if(sum == target){
            return backTracking(matchsticks,target,0,0,set,k-1);
        }for(int i = index ; i < matchsticks.length ; i++) {
            if (sum + matchsticks[i] > target || set.contains(i)) {
                continue;
            }
            set.add(i);
            if(backTracking(matchsticks,target,i+1,sum+matchsticks[i],set,k)){
                return true;
            }
            set.remove(i);
            return backTracking(matchsticks,target,i+1,sum,set,k);
        }
        return false;
    }
    static boolean canMatch(int[] nums){
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        if(totalSum%4 != 0 || nums.length < 4) return false;
        Arrays.sort(nums);
        return canSquare(nums,nums.length-1,new int[4],totalSum/4);
    }
    static boolean canSquare(int[] nums,int index,int []bucket,int target){
        if(index == -1){
            return true;
        }
        for(int j = 0 ; j < 4 ; j++){
            if(bucket[j]+nums[index] <= target){
                bucket[j] += nums[index];
                if(canSquare(nums,index-1,bucket,target)){
                    return true;
                }
                bucket[j] -= nums[index];
            }
            if(bucket[j] == 0){
                break;
            }
        }
        return false;
    }
}
