package leetcode.array;

import java.util.HashMap;

public class MaxPointsInLine {
    public static void main(String[] args) {
        int[][] points = {{1,1},{2,2},{3,3}};//{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        System.out.println(maxPoint(points));
    }
    static int maxPoint(int[][] points){
        int max = 0 ;
        for(int i = 0 ; i < points.length ; i++){
            HashMap<Double,Integer> map = new HashMap<>();
            for(int j = 0 ; j < points.length ; j++){
                if(j==i) continue;
                double y2y1 = points[j][1]-points[i][1];
                double x2x1 = points[j][0]-points[i][0];
                double result = y2y1/x2x1;
                if(map.containsKey(result)){
                    map.put(result,map.get(result)+1);
                }else{
                    map.put(result,1);
                }
                max = Math.max(max,map.get(result));
            }
            System.out.println(map);
        }
        return max+1;
    }
}
