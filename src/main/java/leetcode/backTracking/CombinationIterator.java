package leetcode.backTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationIterator{
    List<String> list = new ArrayList<>();
    int index = 0;

    public static void main(String[] args) {
        CombinationIterator cI = new CombinationIterator("abc",2);
    }
    public CombinationIterator(String characters, int combinationLength) {
        combination(characters,combinationLength,list,"",0);
        System.out.println(list);
    }
    static void combination(String characters,int length,List<String> list, String str,int index){
        if(index >= characters.length()) {
            if (str.length() == length) {
                list.add(str);
            }
            return;
        }
        combination(characters,length,list,str+characters.charAt(index),index+1);
        combination(characters,length,list,str,index+1);
    }

    public String next() {
        int temp = index;
        index++;
        return list.get(temp);
    }

    public boolean hasNext() {
        if(index > list.size()){
            return true;
        }
        return false;
    }
}
