package leetcode.backTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleToIntFunction;

public class CombinationSumIII {
    public static void main(String[] args) {
        System.out.println(combination(3,9));
    }
    static List<List<Integer>>combination (int k , int n){
        List<List<Integer>> list = new ArrayList<>();
        function(list,new ArrayList<>(),1,0,n,k);
        return list;
    }
    static void function(List<List<Integer>> list , List<Integer> l , int index,int sum , int n ,int k){
        if(l.size() == k && sum == n){
            List<Integer> temp = l.stream().toList();
            list.add(temp);
            return;
        }
        if(l.size() >= k || sum >= n || index > 9){
            return;
        }
        l.add(index);
        function(list,l,index+1,sum+index,n,k);
        l.remove(l.size()-1);
        function(list,l,index+1,sum,n,k);
    }
}
