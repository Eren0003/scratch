package leetcode.SlidingWindow;

import java.util.HashMap;

public class MinOperationToReduceX {
    public static void main(String[] args) {
        int [] nums = {5,6,7,8,9};
        int x = 4;
        System.out.println(minOperation(nums,x));
    }
    static int minOperation(int[] nums,int x){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0 ;
        int index = 0 ;
        for(int i : nums){
            sum += i;
            map.put(sum,index);
            index++;
        }
        int target = sum-x;
        int temp = 0 ;
        int result = -1 ;
        for(int i = 0 ; i < nums.length ; i++){
            temp += nums[i];
            if(map.containsKey(temp-target)){
                 result = Math.max(result,i-map.get(temp-target));
            }
        }
        if(result < 0){
            return -1;
        }
        return result;
    }
}