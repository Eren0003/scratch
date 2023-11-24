package leetcode.Dynamic.tabulation;

import java.util.Arrays;

public class CountBits {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(Arrays.toString(count(n)));
    }
    static int[] count(int n){
        int [] result = new int[n+1];
        result[1] = 1;
        int prev = 1;
        int next = 2;
        for(int i = 1 ; i < n+1 ; i++){
            if(i == next){
                result[i] = 1;
                prev = next;
                next = next*2;
            }else if(i < next){
                result[i] = result[prev]+result[i-prev];
            }
        }
        return result;
    }
}
