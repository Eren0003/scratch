package leetcode.Dynamic.tabulation;

import java.util.concurrent.ThreadPoolExecutor;

public class TwoKeysKeyboard {
    public static void main(String[] args) {
        int n = 9 ;
        System.out.println(twoKey(n));
    }
    static int twoKey(int n){
        int A = 1 ;
        if(n == 1) return A;
        int counter = 0;
        int copy = 0;
        while(A < n){
            if(n%A == 0){
                copy = A;
                counter++;
            }
            A += copy;
            counter++;

        }
        return counter;
    }
}
