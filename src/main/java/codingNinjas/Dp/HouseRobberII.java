package codingNinjas.Dp;

import java.util.List;

public class HouseRobberII {
    public static void main(String[] args) {
        System.out.println(houseRobber(new int[]{1,3,2,1}));
    }
    static long houseRobber(int[] valueInHouse){
        long first1 = 0 ;
        long first2 = 0 ;
        long second1 = 0 ;
        long second2 = 0 ;
        for(int i = 0 ; i < valueInHouse.length ; i++){
            if(i != 0 ){
                long sum = Math.max(first2,first1+valueInHouse[i]);
                first1 = first2;
                first2 = sum;
            }if(i != valueInHouse.length-1){
                long sum = Math.max(second2,second1+valueInHouse[i]);
                second1 = second2;
                second2 = sum;
            }
        }
        return Math.max(first2,second2);
    }
}
