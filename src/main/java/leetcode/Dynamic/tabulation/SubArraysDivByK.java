package leetcode.Dynamic.tabulation;

import java.util.Arrays;

public class SubArraysDivByK {
    public static void main(String[] args) {
        int[] nums = {1,-10,5};
        int k = 9;
        System.out.println(subArray(nums,k));
    }
    static int subArray(int[] nums,int k){
        int counter = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            if(i == 0){
                if(nums[i]%k == 0){
                    counter++;
                }
                continue;
            }
            else if(nums[i]%k == 0 && nums[i] != 0){
                counter++;
            }
            nums[i] += nums[i-1];
        }
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i+1 ; j < nums.length ; j++){
                if(nums[i]%k == 0){
                    counter++;
                }
                if((nums[i]-nums[j])%k == 0){
                    counter++;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return counter;
    }
}
