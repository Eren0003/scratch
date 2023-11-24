package subset;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(sum(new int[]{2,3,6,7},7));
    }
    static List<List<Integer>> sum(int[] candidates, int target){
        List<List<Integer>> list = new ArrayList<>();
        int pointer = 0;
        helper(candidates,target,list,new Stack<>(),0,pointer);
        return list;
    }
    static void helper(int [] candidates, int target, List<List<Integer>>list, Stack<Integer> temp, int sum, int pointer){
       if(sum == target){
           List<Integer> l = temp.stream().toList();
           list.add(l);
           return;
       }
       if(sum > target || pointer >= candidates.length){
           return;
       }
       temp.add(candidates[pointer]);
       helper(candidates,target,list,temp,sum+candidates[pointer],pointer);
       temp.pop();
       helper(candidates,target,list,temp,sum,pointer+1);
    }
}
