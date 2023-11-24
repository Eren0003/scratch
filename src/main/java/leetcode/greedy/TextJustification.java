package leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        String [] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(justification(words,maxWidth));
    }
    static int temp = 0;
    static List<String> justification(String[] words, int maxWidth){
        List<String> list =new ArrayList<>();
        int start = 0 ;
        while(start < words.length){
            list.add(helper(start,words,maxWidth));
            System.out.println(list.get(list.size()-1).length());
            start = temp+1;
        }
        temp = 0;
        if(list.size() > 1){
            String [] arr = list.remove(list.size()-1).split("\\s+");
            StringBuilder result = new StringBuilder() ;
            for(int i = 0 ; i < arr.length-1 ; i++){
                result.append(arr[i]);
                result.append(" ");
            }
            result.append(arr[arr.length-1]);
            while(result.length() != maxWidth){
                result.append(" ");
            }
            list.add(result+"");
        }
        return list;
    }
    static String helper(int start , String [] words , int maxWidth){
        int length = 0 ;
        int index = start ;
        while(length < maxWidth && index < words.length){
            if(length+words[index].length()+index-start <= maxWidth) {
                length += words[index].length();
                index++;
            }else{
                break;
            }
        }
        index--;
        int tempStart = start;
        if(start == index){
            while(length < maxWidth){
                words[index] += " ";
                length++;
            }
        }else {
            while (length < maxWidth && start < words.length) {
                words[start] += " ";
                length++;
                start++;
                if (start == index) {
                    start = tempStart;
                }
            }
        }
        temp = index;
        StringBuilder result = new StringBuilder();
        for(int i = tempStart ; i <= index  && i < words.length; i++){
            result.append(words[i]);
        }
        return result+"";
    }
}
