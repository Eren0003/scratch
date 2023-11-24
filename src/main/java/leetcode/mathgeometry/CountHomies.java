package leetcode.mathgeometry;

public class CountHomies {
    public static void main(String[] args) {
        System.out.println(countHomogenous("abbcccaa"));
    }
    static int countHomogenous(String s) {
        int MOD = 1000000007;
        int result = 0;
        char prev = '-';
        int num = 1;
        for(int i = 0 ; i < s.length() ; i++){
            if(prev == s.charAt(i)){
                num += 1;
                result = (result+num)%MOD;
            }else{
                num = 1;
                result += num;
            }
            prev = s.charAt(i);
        }
        return result;
    }
}
