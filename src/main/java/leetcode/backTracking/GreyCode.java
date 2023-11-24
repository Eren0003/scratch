package leetcode.backTracking;

import java.util.ArrayList;
import java.util.List;

public class GreyCode {
    public static void main(String[] args) {
        System.out.println(binary(2));
    }
    static List<Integer> binary(int n){
        List<Integer> binary = new ArrayList<>();
        function("",binary,0,n);
        return binary;
    }
    static void function(String str, List<Integer> binary , int index,int n){
        if(index == n){
            binary.add(Integer.parseInt(str,2));
            return;
        }
        function(str+"1",binary,index+1,n);
        function(str+"0",binary,index+1,n);
    }
}
