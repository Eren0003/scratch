package leetcode.twopointer;

import java.util.HashMap;

public class MaxNumKSum {
    public static void main(String[] args) {
        int[] nums = {4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4};
        int k = 2;
        System.out.println(maxNums(nums,k));
    }

    static int maxNums(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int result = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(k-nums[i])){
                    result++;
                    if(map.get(k-nums[i]) > 1) {
                        map.put(k - nums[i], map.get(k - nums[i]) - 1);
                    }else{
                        map.remove(k-nums[i]);
                    }
            }else{
                if(map.containsKey(nums[i])){
                   map.put(nums[i],map.get(nums[i])+1);
                }else {
                    map.put(nums[i], 1);
                }
            }
            System.out.println(map);
        }
        return result;
    }
}
