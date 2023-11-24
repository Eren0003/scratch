package leetcode.stack;

import java.util.*;

public class RemoveDuplicate {
    public static void main(String[] args) {
        String s = "abacb";
        System.out.println(duplicate(s));
    }
    static String duplicate(String s){
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a'] += 1;
        }
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        for(int i = 0 ; i < s.length() ; i++){
            while(!stack.isEmpty() && !set.contains(s.charAt(i)) && stack.peek()>s.charAt(i) && freq[stack.peek()-'a'] != 0){
                set.remove(stack.pop());
            }
            if(!set.contains(s.charAt(i))) {
                stack.add(s.charAt(i));
                set.add(s.charAt(i));
            }
            freq[s.charAt(i)-'a'] -= 1;
        }
        StringBuilder result = new StringBuilder();
        for(char c : stack){
            result.append(c);
        }
        return result.toString();
    }
}
