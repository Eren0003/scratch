package leetcode.backTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationII {
    public static void main(String[] args) {
        System.out.println(permutation(new int[]{1,1,2}));
    }
    static List<List<Integer>> permutation(int[] nums){
        Set<List<Integer>> set  = new HashSet<>();
        function(set,nums,0);
        return set.stream().toList();
    }
    static void function(Set<List<Integer>> set , int[] nums ,int start){
        if(start == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int i : nums){
                list.add(i);
            }
            set.add(list);
            return;
        }
        for(int i = start ; i < nums.length ; i++){
            swap(nums,i,start);
            function(set,nums,start+1);
            swap(nums,i,start);
        }

    }
    static void swap(int[] nums , int a , int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
