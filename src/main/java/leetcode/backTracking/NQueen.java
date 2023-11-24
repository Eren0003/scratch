package leetcode.backTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueen {
    public static void main(String[] args) {
        List<List<String>> string = queen(9);
        for(List<String> s : string){
            for(String str : s){
                for (char c : str.toCharArray()) {
                    System.out.print(c+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println(string.size());
    }
    static List<List<String>>queen(int n){
        int [] nums = new int[n];
        List<List<String>> string = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            nums[i] = i;
        }
        function(string,nums,0);
        return string;
    }
    static void function(List<List<String>>string, int[] arr, int start) {
        if (start == arr.length) {
            for(int i = 0 ; i < arr.length ; i++) {
                for (int j = i+1; j < arr.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (Math.abs(i - j) == Math.abs(arr[i] - arr[j])) {
                        return;
                    }
                }
            }List<String> s  = new ArrayList<>();
            for (int k : arr) {
                String temp = "";
                for (int j = 0; j < arr.length; j++) {
                    if (k == j) {
                        temp += "Q";
                    } else {
                        temp += ".";
                    }
                }
                s.add(temp);
            }
            string.add(s);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            function(string, arr, start + 1);
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
