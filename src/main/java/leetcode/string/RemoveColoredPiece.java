package leetcode.string;

import java.util.Arrays;
import java.util.HashMap;

public class RemoveColoredPiece {
    public static void main(String[] args) {
        String colors = "AAAABABB";
        System.out.println(frogJump(6,new int[]{30,10,60,10,60,50}));
    }
    static boolean winnerOfGame(String colors) {
        int i = 0;
        char prev1 = '-';
        char prev2 = '-';
        int alice = 0;
        int bob = 0;
        while (i < colors.length()) {
            if (prev1 == prev2 && prev1 == colors.charAt(i)) {
                if (colors.charAt(i) == 'A') {
                    alice++;
                } else {
                    bob++;
                }
            }
            prev2 = prev1;
            prev1 = colors.charAt(i);
            i++;
        }
        if (alice - bob > 0) {
            return true;
        }
        return false;
    }
    public static long countDistinctWayToClimbStair(long nStairs) {
        long prev1 = 1 ;
        long prev2 = 2 ;
        if(nStairs == 1 || nStairs == 0) return 1 ;
        for(long i = 3 ; i <= nStairs ; i++){
            long sum = (prev1 + prev2)%1000000007;
            prev1 = prev2;
            prev2 = sum ;
        }
        return prev2 ;
    }
    public static int frogJump(int n, int[] heights) {
        int prev1 = Math.abs(heights[0]-heights[1]);
        int prev2 = 0 ;
        if(heights.length == 1){
            return 0;
        }
        for(int i = 2 ; i < n ; i++){
            int temp = Math.min(Math.abs(heights[i-1]-heights[i])+prev1,Math.abs(heights[i-2]-heights[i])+prev2);
            prev2 = prev1;
            prev1 = temp;
        }
        return prev1;
    }
}
