package leetcode.Dynamic.memorization;

import java.util.HashMap;

public class InterLeavingString {
    public static void main(String[] args) {
        System.out.println(leaving("aabd","abdc","aabdabcd"));
    }
    static boolean leaving(String s1, String s2, String s3){
        HashMap<String,Boolean> map = new HashMap<>();
        return leave(s1,s2,s3,map);
    }
    static boolean leave(String s1,String s2 , String s3,HashMap<String,Boolean> map){
        if(s3.isEmpty() && s1.isEmpty() && s2.isEmpty()){
            return true;
        }
        if(map.containsKey(s1+" "+s2)){
            return map.get(s1+" "+s2);
        }
        String temp = "";
        for(int i = 0 ; i < s3.length() ; i++){
            temp += s3.charAt(i);
            if(!s1.isEmpty() && temp.length() <= s1.length() && temp.equals(s1.substring(0,temp.length()))) {
                if (leave(s1.substring(temp.length()), s2, s3.substring(temp.length()),map)) {
                    map.put(s1+" "+s2,true);
                    return true;
                }
            }if(!s2.isEmpty() && temp.length() <= s2.length() && temp.equals(s2.substring(0,temp.length()))) {
                if (leave(s1, s2.substring(temp.length()), s3.substring(temp.length()),map)) {
                    map.put(s1+" "+s2,true);
                    return true;
                }
            }
        }
        map.put(s1+" "+s2,false);
        return map.get(s1+" "+s2);
    }
}
