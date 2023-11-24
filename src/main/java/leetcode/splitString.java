package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class splitString {
    public static void main(String[] args) {
        int n = 46288;int p = 3;
//        System.out.println(digPow(n,p));
        String s = "  hello world  ";
        System.out.println(reverseWords(s));
    }
    static int digPow(int n , int p){
        String m = String.valueOf(n);
        int sum = 0;
        int i = 0 ;
        while(i < m.length()){
            int temp = Integer.parseInt(m.charAt(i)+"");
            sum += Math.pow(temp,p);
            i++;
            p++;
        }
        if(sum%n == 0){
            return sum/n;
        }
        else{
            return -1;
        }
    }
    static String reverseWords(String s) {
        String[] array  = s.split("\\s+");
        StringBuilder answer = new StringBuilder();
        System.out.println(array.length);
        for(int i = array.length-1 ; i >= 0 ; i--){
            if(array[i].equals(" ") || array[i].isEmpty()){
                continue;
            }
            answer.append(" ").append(array[i]);
        }
        return answer.substring(1);
    }
}
