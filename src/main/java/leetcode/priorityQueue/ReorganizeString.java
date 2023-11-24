package leetcode.priorityQueue;

import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ReorganizeString {
    public static void main(String[] args) {
        System.out.println(reorganize("bbbbbbaab"));
    }
    static String reorganize(String s){
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->b[1]-a[1]);
        int[] nums = new int[26];

        for(char c : s.toCharArray()){
            nums[c-'a'] += 1;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != 0){
                queue.add(new int[]{i+'a',nums[i]});
            }
        }
        StringBuilder result = new StringBuilder();
        char prev ='-';
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            if(prev != (char)temp[0]) {
                result.append((char) temp[0]);
                if(temp[1] > 1) {
                    queue.offer(new int[]{temp[0],temp[1]-1});
                }
                prev = (char)temp[0];
            }else if(!queue.isEmpty()) {
                int[] temp2 = queue.poll();
                result.append((char) temp2[0]);
                queue.add(temp);
                if(temp2[1] > 1){
                    queue.offer(new int[]{temp2[0],temp2[1]-1});
                }
                prev = (char)temp2[0];
            }else{
                return "";
            }
        }
        return result.toString();
    }
}
