package leetcode.Dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreakII {
    public static void main(String[] args) {
        List<String> wordDict = List.of("apple","pen","applepen");
        String target = "applepenapplepen";
//        System.out.println(word(target,wordDict));
        System.out.println(anotherWay(target,wordDict));
    }
    static List<String> word(String s, List<String> wordDict){
        List<String> result = new ArrayList<>();
        HashMap<String,String> map = new HashMap<>();
        backTrack(s,wordDict,"",result);
        return result;
    }
    static void backTrack(String s, List<String> wordDict , String listTemp ,List<String> list){
        if(s.isEmpty()){
            list.add(listTemp);
            return ;
        }
        String temp = "";
        for(int i = 0 ; i < s.length() ; i++){
            temp += s.charAt(i);
            if(wordDict.contains(temp)){
                if(listTemp.isEmpty()) {
                    backTrack(s.substring(temp.length()), wordDict, temp, list);
                }else{
                    backTrack(s.substring(temp.length()),wordDict,listTemp+" "+temp,list);
                }
            }
        }
    }
    static List<String> anotherWay(String s, List<String> wordDict){
        HashMap<String ,List<String>>map = new HashMap<>();
        return way(s,wordDict,map);
    }
    static List<String> way(String s, List<String> wordDict,HashMap<String,List<String>> map){
        List<String> result= new ArrayList<>();
        if(s.isEmpty()){
            return result;
        }
        String temp = "";
        for(int i = 0 ; i < s.length() ; i++){
            temp += s.charAt(i);
            if(wordDict.contains(temp)){
                List<String> res = way(s.substring(temp.length()),wordDict,map);
                if(res.isEmpty()){
                    res.add(temp);
                }else {
                    for (String s1 : res) {
                        res.remove(s1);
                        res.add( s1+" "+temp);
                    }
                }
                result = res;
            }
        }
        return result;
    }


}
