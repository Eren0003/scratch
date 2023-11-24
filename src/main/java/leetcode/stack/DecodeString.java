package leetcode.stack;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "abc3[cd2[m]]xyz";   // 49=1 : 57=9 : 97=a : z=122 : 91=[ : 93=]
        System.out.println(anotherDecoder(s));
    }

    //    static String decod(String s){
//
//    }
    static String decode(String s) {
        Stack<Integer> num = new Stack<>();
        String str = "";
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 49 && s.charAt(i) <= 57) {
                num.add(Integer.parseInt(s.charAt(i) + ""));
                str = helper(s, i + 2);
                int temp = num.peek();
                for (int j = 0; j < temp; j++) {
                    result += str;
                }
            }
        }
        System.out.println(num);
        return result;
    }

    static String helper(String s, int index) {
        String result = "";
        for (int i = index; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp >= 97 && temp <= 122) {
                result += temp;
            } else {
                break;
            }
        }
        return result;
    }

    static String anotherDecoder(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> num = new Stack<>();
        String result = "";
        int index = 0;
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                num.push(count);
            }else if(s.charAt(index) == '['){
                stack.push(result);
                result = "";
                index++;
            }else if(s.charAt(index) == ']'){
                StringBuilder temp = new StringBuilder(stack.pop());
                int count = num.pop();
                while(count != 0){
                    temp.append(result);
                    count--;
                }
                result = temp.toString();
                index++;
            }else{
                result += s.charAt(index);
                index++;
            }
        }
        return result;
    }
}

