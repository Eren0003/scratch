package leetcode.Dynamic.memorization;

import java.util.HashMap;

public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(game(nums));
    }
    static int game(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        int result = dfs(nums,0,0,map);
        System.out.println(map);
        return result;
    }
    static int dfs(int[] nums,int index,int level,HashMap<Integer,Integer>map){
        if(index >= nums.length-1){
            return level;
        }
        if(map.containsKey(index)){
            return map.get(index);
        }
        int result = nums.length;
        int loop = nums[index];
        while(loop != 0){
            int temp = dfs(nums,index+1,level+1,map);
            result = Math.min(temp,result);
            loop--;
            index++;
        }
        map.put(index,result);
        return result;
    }
}
