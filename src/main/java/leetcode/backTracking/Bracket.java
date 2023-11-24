package leetcode.backTracking;

public class Bracket {
    public static void main(String[] args) {
//        System.out.println(bracket("((ab)cd(ef))"));
        System.out.println(18820/10);
    }
    static String bracket(String s){
        return backtring(s,0,"");
    }
    static String backtring(String s ,int index,String res){

        String result = "";
        if(s.length() == index){
            return res;
        }
        else if(s.charAt(index) == '('){
            result = backtring(s,index+1,res);
        }else if(s.charAt(index) == ')') {
            result = rev(res);
            backtring(s,index+1,result);
        }else{
            result += res;
            for(int i = index ; i < s.length() ; i++){
                if(s.charAt(i) != '(' && s.charAt(i) != ')') {
                    result += s.charAt(i);
                }else{
                    result = backtring(s,i,result);
                }
            }
        }
        return result;
    }
    static String rev(String s){
        String result = "";
        for(int i = s.length()-1 ; i >= 0 ; i--){
            result += s.charAt(i);
        }
        return result;
    }

}
