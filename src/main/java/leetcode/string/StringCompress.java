package leetcode.string;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;

public class StringCompress {
    public static void main(String[] args) {
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(chars));
    }
    static int compress(char[] chars){
        StringBuilder result = new StringBuilder();
        char prev = chars[0];
        int counter = 0 ;
        for(char c : chars){
            if(prev == c){
                counter += 1;
            }else{
                if(counter > 1){
                    result.append(prev).append(counter);
                }else{
                    result.append(prev);
                }
                prev = c;
                counter = 1 ;
            }
        }
        if(counter > 1){
            result.append(prev).append(counter);
        }else{
            result.append(prev);
        }
        for(int i = 0 ;i < result.length() ; i++){
            chars[i] = result.charAt(i);
        }
        System.out.println(Arrays.toString(chars));
        return result.length();
    }
}
