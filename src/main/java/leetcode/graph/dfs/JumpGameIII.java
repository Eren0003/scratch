package leetcode.graph.dfs;

import java.util.HashSet;
import java.util.Set;

public class JumpGameIII {
    public static void main(String[] args) {
        int [] arr = {4,2,3,0,3,1,2};
        int start = 5 ;
        System.out.println(game(arr,start));
    }
    static boolean game(int [] arr,int start){
         Set<Integer> set = new HashSet<>();
         if(dfs(arr,start,set)){
             return true;
         }
         return false;
    }
    static boolean dfs(int [] arr,int index,Set<Integer> set){
        if(index > arr.length-1 || index < 0 || set.contains(index)){
            return false;
        }
        if(arr[index] == 0){
            return true;
        }
        set.add(index);
         boolean result =  dfs(arr,index+arr[index],set) || dfs(arr,index-arr[index],set);
         return result;
    }
}
