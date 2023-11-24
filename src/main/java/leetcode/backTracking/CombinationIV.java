package leetcode.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationIV {
    public static void main(String[] args) {
        System.out.println(combination(new int[]{1,2,3},4));
    }
    static int combination(int[] nums,int target){
        Arrays.sort(nums);
        if(target > nums[0]) return 0;
        List<List<Integer>> num = new ArrayList<>();
        function(nums,new ArrayList<>(),num,0,target,0);
        return num.size();
    }
    static void function(int[] nums, List<Integer> l ,List<List<Integer>> num, int index,int target,int sum){
        if(target == sum && !num.contains(l)){
            List<Integer> temp = l.stream().toList();
            num.add(temp);
            return;
        }
        if(target < sum || index >= nums.length){
            return;
        }
        for(int i = index ; i < nums.length ; i++){
            l.add(nums[i]);
            function(nums,l,num,index,target,sum+nums[i]);
            l.remove(l.size()-1);
            function(nums,l,num,index+1,target,sum);
        }
    }
}
