package leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findAndReplacePattern {
    public static void main(String[] args) {
        String[] word = {"ccc","mee","aqq"};
        String pattern = "abb";
        System.out.println(replacePattern(word,pattern));
    }
    static List<String> replacePattern(String[] words, String pattern){
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < words.length ; i++){
            String word = words[i];
            HashMap<Character,Character> map = new HashMap<>();
            int counter = 0 ;
            if(pattern.length() == word.length()) {
                for (int j = 0; j < pattern.length(); j++){
                    if(map.containsKey(pattern.charAt(j))){
                        if(map.get(pattern.charAt(j)) != word.charAt(j)){
                            break;
                        }counter++;
                    }
                    else if(!map.containsValue(word.charAt(j))){
                        map.put(pattern.charAt(j),word.charAt(j));
                        counter++;
                    }
                }
                if(counter == pattern.length()){
                    list.add(word);
                }
            }
        }
        return list;
    }
}
