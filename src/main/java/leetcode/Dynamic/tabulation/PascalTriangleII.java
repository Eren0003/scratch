package leetcode.Dynamic.tabulation;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public static void main(String[] args) {
        int rowIndex = 3;
        System.out.println(row(rowIndex));
    }
    static List<Integer> row (int rowIndex){
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(1));
        if(rowIndex == 1 ) {
            return List.of(1,1);
        }
        int counter = 1 ;
        while(counter <= rowIndex){
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
        return list.get(rowIndex);
    }
}
