package leetcode.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FruitIntoBasket {
    public static void main(String[] args) {
        System.out.println(basket(new int[]{3,3,3,3,3}));
    }
    static int basket(int[] fruits){
        HashMap<Integer,Integer> map = new HashMap<>();
        int start = 0; int end = 0;
        int max = 0;
        if(fruits.length <= 2) return fruits.length;
        while(start <= end && end <= fruits.length){
            if(map.size() <= 2){
                max = Math.max(max,end-start);
                if(end == fruits.length){
                    return max;
                }
            }
            if(map.size() <= 2){
                if(map.containsKey(fruits[end])){
                    map.put(fruits[end],map.get(fruits[end])+1);
                }else {
                    map.put(fruits[end], 1);
                }
                end++;
            }else if(map.size() > 2){
                if(map.get(fruits[start]) == 1){
                    map.remove(fruits[start]);
                }else{
                    map.put(fruits[start],map.get(fruits[start])-1);
                }
                start++;
            }
        }
        return max;
    }
}