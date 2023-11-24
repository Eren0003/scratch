package leetcode.priorityQueue;

import com.sun.source.doctree.SeeTree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Monster {
    public static void main(String[] args) {
        System.out.println(eliminateMaximum(new int[]{4,2,3},new int[]{2,1,1}));
    }
    static int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
            return a[0]-b[0];
        });
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < dist.length ; i++){
            if(dist[i]%speed[i] == 0){
                if(!set.contains(dist[i]/speed[i])){
                    queue.offer(new int[]{dist[i]/speed[i],0});
                }else{
                    queue.offer(new int[]{dist[i]/speed[i],-1});
                }
                set.add(dist[i]/speed[i]);
            }else{
                if(!set.contains((dist[i]/speed[i])+1)){
                    queue.offer(new int[]{(dist[i]/speed[i])+1,0});
                }else{
                    queue.offer(new int[]{(dist[i]/speed[i])+1,-1});
                }
                set.add((dist[i]/speed[i])+1);
            }
        }
        int result =  0;
        while(!queue.isEmpty()){
            System.out.println(Arrays.toString(queue.poll()));
//            if(queue.poll()[1] != -1){
//                result += 1;
//            }else{
//                break;
//            }
        }
        return result;
    }
}
