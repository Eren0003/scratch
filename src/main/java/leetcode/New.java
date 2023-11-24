package leetcode;

import java.util.*;

public class New {
    public static void main(String[] args) {
//        String s = "128093107";
//        System.out.println(method(s));
//        System.out.println("mm");
        String s= "";
        List<List<Integer>> list = List.of(List.of(6,7,8),List.of(5,4,9),List.of(),List.of(8),List.of(4),
                List.of(),List.of(1,9,2,3),List.of(7),List.of(6,5),List.of(2,3,1));
//        System.out.println(canVisitAllRooms(list));
//        System.out.println(addToArrayForm(new int[]{2,7,4},181));
//        System.out.println(Integer.toBinaryString());
    }
    static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<>();
        boolean carry = false;
       for(int i = num.length-1 ; i >= 0 ; i--){
           if(carry){
               num[i] += 1;
           }
           if(num[i]+(k%10) > 9) {
               list.add(0,(num[i]+(k%10))%10);
               carry = true;
           }else{
               list.add(0,num[i]+(k%10));
               carry = false;
           }
           k = k/10;
       }
       while(k != 0){
           list.add(0,k%10);
           k = k/10;
       }
       return list;
    }
    static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[]dp = new boolean[rooms.size()];
        dp[0] = true;
        for(int i = 0 ; i < rooms.size() ; i++){
            Set<Integer> set = new HashSet<>();
            dfs(dp,rooms,rooms.get(0),set,0);
        }
        System.out.println(Arrays.toString(dp));
        for(int i = 0 ; i < dp.length ; i++){
            if(!dp[i]){
                return false;
            }
        }
        return true;
    }
    static void dfs(boolean[] dp,List<List<Integer>> rooms, List<Integer> list , Set<Integer> set,int index){
        if(set.contains(index)){
            return ;
        }
        set.add(index);
        for(int i = 0 ; i < list.size() ; i++){
            dp[list.get(i)] = true;
            dfs(dp,rooms,rooms.get(list.get(i)),set,list.get(i));
            set.add(list.get(i));
        }
    }
    static int method(String s){
        int counter = 0 ;
        int length = s.length();
        for(int i = length-1  ; i >= 0 ; i--){
            int num = s.charAt(i) - 48;
            if(num <= 9 && num != 0){
                counter = counter+1;
            }
            if(num == 0){
                int nums = s.charAt(i-1) - 48;
                if(nums == 1 || nums == 2){
                    counter = counter+1;
                    i++;
                }
            }
        }
        return counter;
    }
}

