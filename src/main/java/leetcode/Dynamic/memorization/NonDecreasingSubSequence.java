package leetcode.Dynamic.memorization;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class NonDecreasingSubSequence {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        System.out.println(subSequence(nums));
    }
    static List<List<Integer>> subSequence(int[] nums){
        List<List<Integer>> list =  new ArrayList<>();
        dfs(list,nums,0,new ArrayList<>());
        return list;
    }
    static void dfs(List<List<Integer>> result , int[] nums,int index ,List<Integer> list){
        if(list.size() >= 2){
            List<Integer> temp = list.stream().toList();
            if(!result.contains(temp)) {
                result.add(temp);
            }
        }
        for(int i = index ; i < nums.length ; i++) {
            if (list.isEmpty() || nums[i] >= list.get(list.size() - 1)) {
                list.add(nums[i]);
                dfs(result, nums, i+1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
