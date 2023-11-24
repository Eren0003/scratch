package leetcode.hash;

import java.util.HashMap;

public class NumberOfGoodPair {
    public static void main(String[] args) {
        System.out.println(numIdentify(new int[]{1,1,1,1,1,1}));
    }
    static int numIdentify(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        int counter = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(nums[i])){
                int num = map.get(nums[i]);
                counter += num;
                map.put(nums[i],num+1);
            }else{
                map.put(nums[i],1);
            }
        }
        return counter;
    }
}
