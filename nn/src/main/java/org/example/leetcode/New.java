package org.example.leetcode;

public class New {
    public static void main(String[] args) {
        String s = "128093107";

        System.out.println(method(s));
        System.out.println("mm");
    }
    static int method(String s){
        int counter = 0 ;
        int length = s.length();
        for(int i = length-1  ; i >= 0 ; i--){
            int num = s.charAt(i) - 48;
            if(num <= 9 && num != 0){
                counter = counter+1;
            }
            if(num == 0){
                int nums = s.charAt(i-1) - 48;
                if(nums == 1 || nums == 2){
                    counter = counter+1;
                    i++;
                }
            }
        }
        return counter;
    }
}

