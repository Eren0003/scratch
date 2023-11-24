package leetcode.Dynamic.memorization;

import java.util.HashMap;

public class JumpGame {
    public static void main(String[] args) {
        int [] nums = {2,0,0};
        System.out.println(game(nums));
    }
    static boolean game(int [] nums){
        HashMap<Integer,Boolean> map = new HashMap<>();
         return dfs(nums,0,map);
    }
    static boolean dfs(int [] nums,int index ,HashMap<Integer,Boolean> map){
        if(index == nums.length-1){
            return true;
        }
        if(map.containsKey(index)){
            return map.get(index);
        }
        int counter = nums[index];
        for(int i = 1 ; i <= counter ; i++){
             if(dfs(nums,index+1,map)){
                 map.put(index,true);
                 return true;
             }
        }
        map.put(index,false);
        return false;
    }
}
