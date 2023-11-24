package leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class MinDeletionToMakeFrequencyUnique {
    public static void main(String[] args) {
        String s = "aaabbbcc";
        System.out.println(minDeletion(s));
    }
    static int minDeletion(String s){
        int[] count = new int[26];
        List<Integer> list = new ArrayList<>();
        for(char c :s.toCharArray()){
            count[c-'a'] += 1;
        }
        int result = 0 ;
        for(int i = 0 ; i < count.length ; i++){
            if(list.contains(count[i])){
                while(count[i] != 0){
                    count[i] -= 1;
                    result += 1;
                    if(!list.contains(count[i])){
                        list.add(count[i]);
                        break;
                    }
                }
            }else{
                list.add(count[i]);
            }
        }
        return result;
    }
}
