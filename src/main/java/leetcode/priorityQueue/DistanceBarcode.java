package leetcode.priorityQueue;

import com.sun.source.doctree.SeeTree;

import java.util.*;

public class DistanceBarcode {
    public static void main(String[] args) {
        int [] barcodes = {1,1,1,1,2,2,3,3};
        System.out.println(Arrays.toString(distance(barcodes)));
    }
    static int [] distance (int[] barcodes){
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->b[1]-a[1]);
        HashMap<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i : barcodes){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
            set.add(i);
        }
        for(int i : set){
            int temp = map.get(i);
            queue.offer(new int[]{i,temp});
        }
        int prev = -1 ;
        for(int i = 0 ;i < barcodes.length && !queue.isEmpty() ; i++){
            int [] temp = queue.peek();
            int [] store;
            if(prev == temp[0]){
                temp = queue.poll();
                store = queue.peek();
                barcodes[i] = store[0];
                queue.poll();
                queue.offer(temp);
            }else{
                barcodes[i] = temp[0];
                store = queue.poll();
            }
            if(store[1] > 1){
                queue.add(new int[]{store[0],store[1]-1});
            }
            prev = store[0];
        }
        System.out.println(map);
        return barcodes;
    }
}
