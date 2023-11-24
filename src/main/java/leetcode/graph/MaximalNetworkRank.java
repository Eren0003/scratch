package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MaximalNetworkRank {
    public static void main(String[] args) {
        int[][] roads = {{0,1},{0,3},{1,2},{1,3}};
        int n = 4 ;
        System.out.println(maximalRoad(roads,n));
    }

    static int maximalRoad(int[][] roads, int n) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++ ){
            map.put(i,new ArrayList<>());
        }
        for(int[] road : roads){
            if(map.containsKey(road[0])){
                List<Integer> temp = map.get(road[0]);
                temp.add(road[1]);
                map.put(road[0],temp);
            }if(map.containsKey(road[1])){
                List<Integer> temp = map.get(road[1]);
                temp.add(road[0]);
                map.put(road[1],temp);
            }
        }
        int max = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                if(map.get(i).contains(j)){
                     max = Math.max(map.get(i).size()-1+map.get(j).size(),max);
                }else{
                    max = Math.max(map.get(i).size()+map.get(j).size(),max);
                }
            }
        }
        return max;
    }
}
