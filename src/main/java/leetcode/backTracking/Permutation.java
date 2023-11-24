package leetcode.backTracking;

import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        List<List<Integer>> list = new ArrayList<>();
        function(list,nums,0);
        System.out.println(list);
    }
    static void function(List<List<Integer>> ans, int[] arr, int start) {
        if (start == arr.length) {
            List<Integer> list = new ArrayList<>();
            for (int j : arr) {
                list.add(j);
            }
            ans.add(list);
            System.out.println(list);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            function(ans, arr, start + 1);
            swap(arr, start, i);
        }
    }
    static void swap(int[] arr, int a, int b) {
        if(a == b)return ;
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
