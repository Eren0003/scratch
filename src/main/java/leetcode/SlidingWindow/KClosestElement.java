package leetcode.SlidingWindow;

import codeWars.HandShake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KClosestElement {
    public static void main(String[] args) {
        System.out.println(element(new int[]{1,2,4,5,19},4,3));
    }
    static List<Integer> element(int[] arr, int k ,int x){
        List<Integer> list = new ArrayList<>();
        int close = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == x){
                close = i;
                break;
            }else if(arr[i] > x &&
                    Math.abs(arr[close]-x) > Math.abs(arr[i]-x)){
                close = i;
                break;
            }else if(arr[i] > x){
                break;
            }
            else{
                close = i;
            }
        }
        list.add(arr[close]);
        int left = close-1;
        int right = close+1;
        while(list.size() < k){
            if(left < 0){
                list.add(arr[right]);
                right++;
            }else if(right >= arr.length) {
                list.add(arr[left]);
                left--;
            }else{
                int leftDiff = Math.abs(arr[left]-x);
                int rightDiff = Math.abs(arr[right]-x);
                if(leftDiff <= rightDiff){
                    list.add(arr[left]);
                    left--;
                }else{
                    list.add(arr[right]);
                    right++;
                }
            }
        }
        return list.stream().sorted().toList();
    }
}
