package leetcode.priorityQueue;

import com.sun.security.jgss.GSSUtil;

import java.util.PriorityQueue;

public class LongestHappyString {
    public static void main(String[] args) {
        int a = 7 ,b = 1 , c = 0 ;
        System.out.println(happy(a,b,c));
    }
    static String happy(int a , int b , int c){
        StringBuilder result = new StringBuilder();
        PriorityQueue<int[]> queue = new PriorityQueue<>((l,m)->m[1]-l[1]);
        if(a != 0) {
            queue.offer(new int[]{'a', a});
        }if(b != 0) {
            queue.offer(new int[]{'b', b});
        }if(c != 0) {
            queue.offer(new int[]{'c', c});
        }
        char prev = '\0';
        char prevP = '\0';
        while(!queue.isEmpty()){
            int[]temp1 = queue.poll();
            char s = (char)temp1[0];
            if(!(prev == s && prevP == s)){
                result.append(s);
                if(temp1[1] > 1){
                    queue.offer(new int[]{s,temp1[1]-1});
                }
                prevP = prev;
                prev = s ;
            }else if(!queue.isEmpty()){
                int[] temp2 = queue.poll();
                char m = (char)temp2[0];
                result.append(m);
                prevP = prev;
                prev = m ;
                if(temp2[1] > 1){
                    queue.offer(new int[]{m,temp2[1]-1});
                }
                queue.offer(new int []{s,temp1[1]});
            }else{
                return result.toString();
            }
        }
        return result.toString();
    }
}
