package leetcode.Dynamic.tabulation;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(triange(numRows));
    }
    static List<List<Integer>> triange(int numRows){
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(1));
        if(numRows == 1 ) {
            return list;
        }
        int counter = 1 ;
        while(counter < numRows){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            List<Integer> prev = list.get(list.size()-1);
            for(int i = 0 ; i <  prev.size() ; i++){
                if(i+1 < prev.size()){
                    temp.add(prev.get(i)+prev.get(i+1));
                }
            }
            temp.add(1);
            list.add(temp);
            counter++;
        }
        return list;
    }
}
