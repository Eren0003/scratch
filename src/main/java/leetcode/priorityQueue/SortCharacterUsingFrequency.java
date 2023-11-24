package leetcode.priorityQueue;

import java.util.*;

public class SortCharacterUsingFrequency {
    public static void main(String[] args) {
        String s = "bbAa";
        System.out.println(frequency(s));
    }
    static String frequency(String s){
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->b[1]-a[1]);
        StringBuilder result = new StringBuilder();
        List<Character> list = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
                list.add(c);
            }
        }
        for(char c : list){
           queue.offer(new int[]{c,map.get(c)});
        }
        while(!queue.isEmpty()){
            int[] num = queue.poll();
            int count = num[1];
            while(count > 0){
                result.append((char)num[0]);
                count--;
            }
        }
        return result.toString();
    }
}
