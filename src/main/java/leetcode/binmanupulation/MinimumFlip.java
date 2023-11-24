package leetcode.binmanupulation;

import java.util.PriorityQueue;

public class MinimumFlip {
    public static void main(String[] args) {
        System.out.println(minFlips(1,2,3));
    }
    static int minFlips(int a , int b , int c){
        String a1 = Integer.toBinaryString(a);
        String b1 = Integer.toBinaryString(b);
        String c1 = Integer.toBinaryString(c);
        int maxLen = a1.length();
        maxLen = Math.max(maxLen,b1.length());
        maxLen = Math.max(maxLen,c1.length());
        for(int i = maxLen-1 ; i >= 0; i--) {
            if(maxLen > a1.length()){
                a1 = "0"+a1;
            }if(maxLen > b1.length()){
                b1 = "0"+b1;
            }if(maxLen > c1.length()){
                c1 = "0"+c1;
            }
        }
        int result = 0 ;
        for(int i = 0 ; i < maxLen ; i++){
            if(c1.charAt(i) == '0'){
                if(a1.charAt(i) == '1'){
                    result += 1;
                }if(b1.charAt(i) == '1'){
                    result += 1;
                }
            }else{
                if(a1.charAt(i) == '0' && b1.charAt(i) == '0'){
                    result += 1;
                }
            }
        }
        return result;
    }
}
