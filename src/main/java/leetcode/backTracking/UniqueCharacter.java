package leetcode.backTracking;

import java.util.*;

public class UniqueCharacter {
    public static void main(String[] args) {
        System.out.println(character(Arrays.asList("cha","r","act","ers")));
    }
    static int character(List<String> arr){
        Stack<Integer> result = new Stack<>();
        function(arr,result,0,"");
        return result.peek();
    }
    static void function(List<String> arr,Stack<Integer> result, int index ,String str){
        Set<Character> set = new HashSet<>();
        for(int i = 0 ; i < str.length() ; i++) {
            if (set.isEmpty()) {
                set.add(str.charAt(i));
            } else if (set.contains(str.charAt(i))) {
                return;
            } else {
                set.add(str.charAt(i));
            }
        }
        if(index == arr.size()){
            if(result.isEmpty()){
                result.add(str.length());
            }
            else if(result.peek() < str.length()){
                result.pop();
                result.add(str.length());
            }
            return;
        }
        function(arr,result,index+1,str+arr.get(index));
        function(arr,result,index+1,str);
    }
}