package leetcode.Dynamic.tabulation;

import java.util.*;

public class CountSubMultiSet {
    public static void main(String[] args) {
        System.out.println(countSubMultisets(List.of(1,2,2,3),6,6));
    }
    static int countSubMultisets(List<Integer> nums, int l, int r) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> set = new ArrayList<>();
        for(int i : nums){
            map.putIfAbsent(i,0);
            if(!set.contains(i)){
                set.add(i);
            }
            map.put(i,map.get(i)+1);
        }
        int[][] dp = new int[set.size()+1][r+1];
        dp[0][0] = 1;
        for(int ind = 1 ; ind <= set.size() ; ind++){
            for(int target = 0 ; target <= r ; target++){
                int notTake = dp[ind-1][target];
                int take = 0;
                if(target >= set.get(ind-1) && map.get(nums.get(ind-1)) > 0 ){
                    take = dp[ind][target-set.get(ind-1)];
                    map.put(set.get(ind-1),map.get(set.get(ind-1))-1);
                }
                dp[ind][target] = take+notTake;
            }
        }
        for(int [] i : dp){
            System.out.println(Arrays.toString(i));
        }
        return -1;
    }
}
