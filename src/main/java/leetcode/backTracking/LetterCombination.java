package leetcode.backTracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    public static void main(String[] args) {
        System.out.println(number("23"));
    }
    static List<String> number(String digits){
        String[] char_arr = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans = new ArrayList<>();
        ans.add("");
        return function(ans,char_arr,digits,0);
    }
    static List<String> function(List<String> list , String[] char_arr,String digits ,int strIndex){
        if(strIndex == digits.length()){
            return list;
        }
        int num = digits.charAt(strIndex)-'0';
        List<String> result = new ArrayList<>();
        for(String str : list) {
            for (char c : char_arr[num].toCharArray()) {
                result.add(str+c);
            }
        }
        return function(result,char_arr,digits,strIndex+1);
    }

}
