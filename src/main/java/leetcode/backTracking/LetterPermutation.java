package leetcode.backTracking;

import java.util.ArrayList;
import java.util.List;

public class LetterPermutation {
    public static void main(String[] args) {
        char[] arr = new char[]{'c','x','9'};
        System.out.println(combination(arr));
    }
    static List<String> combination(char[] arr){
        List<String> str = new ArrayList<>();
        function(arr,0,str,"");
        return str;
    }
    static void function(char[] arr,int index ,List<String> str,String temp){
        if(arr.length == index){
            str.add(temp);
            return;
        }
        if(Character.isAlphabetic(arr[index]) && Character.isLowerCase(arr[index])) {
            function(arr, index + 1, str, temp + (arr[index] + "").toUpperCase());
        }else if(Character.isAlphabetic(arr[index]) && Character.isUpperCase(arr[index])){
            function(arr,index+1,str,temp+(arr[index]+"").toLowerCase());
        }
        function(arr,index+1,str,temp+arr[index]);
    }
}
