package leetcode.priorityQueue;

import java.util.*;

public class TopKthFrequentWord {
    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        System.out.println(kthFrequent(words,k));
    }
    static List<String> kthFrequent(String[] words, int k){
        HashMap<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(String s : words){
            if(!list.contains(s)){
                list.add(s);
            }
            map.putIfAbsent(s,0);
            map.put(s,map.get(s)+1);
        }
        PriorityQueue<Pojo> queue = new PriorityQueue<>((a,b)->{
            if(a.val == b.val){
                return a.word.compareTo(b.word);
            }
            return b.val-a.val;
        });
        System.out.println(map);
        List<String> result = new ArrayList<>();
        for(String s : list){
            queue.offer(new Pojo(map.get(s), s));
        }
        if(k > queue.size()){
            while(!queue.isEmpty()){
                result.add(queue.poll().word);
            }
        }else {
            while(k != 0) {
                result.add(queue.poll().word);
                k--;
            }
        }
        return result;
    }
    static class Pojo{
        private int val;
        private String word;
        public Pojo(){}
        public Pojo(int val,String word){
            this.val = val;
            this.word = word;
        }
    }
}
