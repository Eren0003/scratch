package leetcode.graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
//["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]
public class ReconstructItinerary {
    public static void main(String[] args) {
        List<List<String>> list = List.of(
                List.of("MUC","LHR")
                ,List.of("JFK","MUC")
                ,List.of("SFO","SJC")
                ,List.of("LHR","SFO"));
        System.out.println(reconstruct(list));
    }
    static List<String> reconstruct(List<List<String>> tickets){
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        PriorityQueue<String> outer = new PriorityQueue<>();
        for(List<String> temp : tickets){
            map.putIfAbsent(temp.get(0),new PriorityQueue<>());
            map.get(temp.get(0)).add(temp.get(1));
        }
        List<String> result = new ArrayList<>();
        dfs("JFK",result,map);
        return result;
    }
    static void dfs(String direction,List<String> result,HashMap<String,PriorityQueue<String>> map){
        PriorityQueue<String> queue =  map.get(direction);
        while(queue != null && !queue.isEmpty()){
            dfs(queue.poll(),result,map);
        }
        result.add(0,direction);
    }
}
