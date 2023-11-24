package leetcode.Dynamic.tabulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(2));
        list.add(List.of(3,4));
        list.add(List.of(6,5,7));
        list.add(List.of(4,1,8,3));
        System.out.println(list);
        int[][]nums = new int[list.get(list.size()-1).size()][list.size()];
//        triangle(list,0,0,0);
        for(int i = 0 ;i < list.size() ; i++){
            for(int j = 0 ; j < list.get(i).size() ; j++){
                nums[i][j] = list.get(i).get(j);
            }
        }
        System.out.println(iterative(nums));
        for(int [] i : nums) {
            System.out.println(Arrays.toString(i));
        }
    }
    static int iterative(int[] [] nums){
        for(int i = nums.length-1; i >= 0; i--){
            for(int j = i ; j >= 0 ; j--){
                if(i == nums.length-1){
                    continue;
                }
                nums[i][j] += Math.min(nums[i+1][j],nums[i+1][j+1]);
            }
        }
        return nums[0][0];
    }
    static int min = Integer.MAX_VALUE;
    static void triangle(List<List<Integer>> triangle,int level,int sum,int index) {
        if (level == triangle.size()) {
            min = Math.min(min,sum);
            return;
        }
        triangle(triangle, level + 1, sum + triangle.get(level).get(index),index);
        if(triangle.get(level).size() > index+1) {
            triangle(triangle, level + 1, sum + triangle.get(level).get(index + 1),index+1);
        }
    }
}
