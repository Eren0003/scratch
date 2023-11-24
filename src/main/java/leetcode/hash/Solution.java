package leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    static HashMap<Integer, List<Integer>> map = new HashMap<>();

    public Solution(int[] nums) {

        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(nums[i])){
                List<Integer> list = new ArrayList<>(map.get(nums[i]));
                list.add(i);
                map.put(nums[i],list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i],list);
            }
        }
    }

    public int pick(int target){
        List<Integer> list = new ArrayList<>(map.get(target));
        double random  = Math.floor(Math.random()*(double)list.size());
        return list.get((int)random);
    }
}
