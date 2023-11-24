package leetcode;

public class MinPenaltyForShop {
    public static void main(String[] args) {
        System.out.println(bestClosingTime("YYNY"));
    }
    static int bestClosingTime(String customers){
        int result = customers.length();
        int penalty = 0 ;
        int leftY = 0 ;
        int rightY = 0 ;
        int leftN = 0 ;
        int rightN = 0 ;
        for(int i = 0 ; i < customers.length() ; i++){
            if(customers.charAt(i) == 'N'){
                leftN += 1;
                penalty += 1;
            }else{
                leftY += 1;
            }
        }

        for(int i = customers.length()-1 ; i >= 0 ; i--){
            if(customers.charAt(i) == 'Y'){
                leftY -= 1;
                rightY += 1;
            }else if(customers.charAt(i) == 'N'){
                leftN -= 1;
                rightN += 1;
            }
            if(rightY+leftN <= penalty){
                penalty = rightY+leftN;
                result = i;
            }
        }
        return result;
    }
}
