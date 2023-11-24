package leetcode.Dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        List<String> list = List.of("aaa","aaaa");
        String s = "aaaaaaa";
        System.out.println(word(s,list));
    }
    static boolean word(String s , List<String> wordDict){
        HashMap<String , Boolean> map = new HashMap<>();
        boolean result =  backTrack(wordDict,s,s,0, map);
        System.out.println(map);
        return result;
    }
    static boolean backTrack ( List<String> wordDict , String curr,String s ,int index,HashMap<String,Boolean> map){
        if(curr.isEmpty()){
            return true;
        }
        if(map.containsKey(curr)){
            return map.get(curr);
        }
        String temp = "";
        for(int i = 0 ; i < curr.length() ; i++){
            temp += curr.charAt(i);
            if(wordDict.contains(temp)){
                if(backTrack(wordDict,curr.substring(temp.length()),s,index+temp.length(),map)){
                    String result = curr;
                    map.put(result, true);
                    return true;
                }
            }
        }
        map.put(curr,false);
        return false;
    }
}
