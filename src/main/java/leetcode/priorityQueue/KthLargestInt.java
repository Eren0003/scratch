package leetcode.priorityQueue;

import java.util.PriorityQueue;

public class KthLargestInt {
    public static void main(String[] args) {
        String[] nums = {"31","3","2","21","12","1"};
        System.out.println(largest(nums,4));
    }
    static  String largest(String[] nums, int k){
        PriorityQueue<String> queue = new PriorityQueue<>((a,b)->{
            if(a.length() == b.length()){
                return a.compareTo(b);
            }
            return Integer.compare(a.length(),b.length());
        });
        for(String s : nums){
            queue.offer(s);
            if(queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }


}
