package leetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class MinimumReplacementSortArray {
    public static void main(String[] args) {
        int [] nums = {19,7,2,24,11,16,1,11,23};
        System.out.println(replacement(nums));
    }
    static int replacement(int[] nums){
        int max = nums[nums.length-1];
        List<Integer> list = new ArrayList<>();
        list.add(max);
        for(int i = nums.length-2 ; i >= 0 ; i--){
            int num = nums[i];
            if(num <= max){
                list.add(num);
                max = num;
            }else {
                while (num > max) {
                    if(num/max >= max) {
                        list.add(max);
                        num = num - max;
                    }else{
                        list.add(num-(num/max));
                        num = num/2;
                    }
                }
                list.add(num);
                max = num;
            }
        }
        return list.size()-nums.length;
    }
}
