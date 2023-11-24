package leetcode.string;

public class DecodeStringAtIndex {
    public static void main(String[] args) {
        String s = "leet2code3";
        int k = 10;
        System.out.println(decode(k,s));
    }
    static String decode(int k , String s){
        String result = "";
        long len = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            if(Character.isDigit(s.charAt(i))){
                len *= s.charAt(i)-'0';
            }else{
                len += 1;
            }
        }
        for(int i = s.length()-1 ; i >= 0 ; i--){
            if(Character.isDigit(s.charAt(i))){
                len /= s.charAt(i)-'0';
                k %= len;
            }else{
                len -= 1;
            }
            if(k == i+1){
                return result+s.charAt(i);
            }
        }
        return "0";
    }
}
