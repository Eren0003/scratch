package leetcode.backTracking;

import java.util.ArrayList;
import java.util.List;

public class nQueenII {
    public static void main(String[] args) {
        System.out.println(queen(4));
    }
    static int queen(int n){
        int []nums = new int[n];
        for(int i = 0 ; i < n ; i++ ){
            nums[i] = i+1;
        }
        List<Integer> list = new ArrayList<>();
        function(list,nums,0);
        return list.size();
    }
    static void function(List<Integer> ans, int[] arr, int start) {
        if (start == arr.length) {
            for(int i = 0 ; i < arr.length ; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (Math.abs(i - j) == Math.abs(arr[i] - arr[j])) {
                        return;
                    }
                }
            }
            ans.add(0);
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
