package leetcode.backTracking;

import java.util.*;

public class UniqueBinaryString {
    public static void main(String[] args) {
        System.out.println(binary(new String[]{"111","011","001"}));
    }
    static String binary(String[] nums){
        List<String> list = new ArrayList<>();
        String result = "";
        List<String> num = Arrays.asList(nums);
        result = backtrack(0,"",nums[0].length(),num);
        return result;
    }
    static String backtrack(int index , String binary,int length ,List<String>num){
        if(index == length){
            String temp = binary;
            if(!num.contains(temp)){
                return temp;
            }else {
                return "";
            }
        }
        String res = backtrack(index+1,binary+"1",length,num);
        if(res == "") {
            res = backtrack(index + 1, binary + "0", length, num);
        }
        return res;
    }

}
