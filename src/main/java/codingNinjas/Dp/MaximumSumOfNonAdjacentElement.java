package codingNinjas.Dp;

import java.util.List;

public class MaximumSumOfNonAdjacentElement {
    public static void main(String[] args) {
        List<Integer> list = List.of(76,31,35,96,7,20,22,6,92,76);
        System.out.println(sum(list));
    }
    static int sum(List<Integer> nums){
        int prev1 = nums.get(0);
        if(nums.size() == 1) return prev1;
        int prev2 = nums.get(1);
        if(nums.size() == 2) return Math.max(prev1,prev2);
        for(int i = 2 ; i < nums.size() ; i++){
            int curr= Math.max(prev2,prev1+nums.get(i));
            prev1 = prev2;
            prev2 = curr;
        }
        return prev2;
    }
}
