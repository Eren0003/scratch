package leetcode.graph.bfs;

import java.util.*;

public class CheapestFlight {
    public static void main(String[] args) {
        System.out.println(findCheapestPrice(4,new int[][]{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}},0,3,1));
    }
    static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for(int i = 0 ; i < flights.length ; i++){
            if(map.containsKey(flights[i][0])){
                List<int[]> num = new ArrayList<>(map.get(flights[i][0]));
                num.add(new int[]{flights[i][1],flights[i][2]});
                map.put(flights[i][0],num);
            }else{
                List<int[]> num = new ArrayList<>();
                num.add(new int[]{flights[i][1],flights[i][2]});
                map.put(flights[i][0],num);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        while(!queue.isEmpty()){

        }
        return -1;
    }
}
