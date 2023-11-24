package leetcode.Dynamic.tabulation;

import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;

public class Fibo {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(fib(50));
    }
    static int fib(int n ){
        int[] fib = new int[n+1];
        fib[1] = 1;
        for(int i = 0 ; i <= n ; i++){
             if(i+1 <= n && i+2 <= n){
                 fib[i+1] += fib[i];
                 fib[i+2] += fib[i];
             }else if(i+1 <= n){
                 fib[i+1] += fib[i];
             }
        }
        System.out.println(Arrays.toString(fib));
        return fib[n];
    }
}
