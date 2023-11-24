package leetcode.Dynamic.tabulation;

public class MaxSwap {
    public static void main(String[] args) {
        System.out.println(swap(2736));
    }
    static int swap(int num){
        String s = String.valueOf(num);
        int result = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            char left = s.charAt(i);
            for(int j = i+1 ; j < s.length() ; j++){
                char right = s.charAt(j);
                String temp = s.substring(0,i)+right+s.substring(i+1,j)+left+s.substring(j+1);
                result = Math.max(Integer.parseInt(temp),result);
            }
        }
        return result;
     }
}
