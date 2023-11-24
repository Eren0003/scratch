package leetcode.Dynamic.tabulation;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class CoinChangeII {
    public static void main(String[] args) {
        int amount = 10000;
        System.out.println((amount*15)/100);
//        System.out.println(possibleCoins(new int[]{1,2,3},7));
//        System.out.println(permutation(new int[]{}));
    }
    static void permutation(int[] arr){

    }
    static int possibleCoins(int[] coins, int amount){
     int [] curr = new int[amount+1];
     int [] prev = new int[amount+1];
     prev[0] = 1;
     for(int ind = 1 ; ind <= coins.length ; ind++){
         for(int target = 0 ; target <= amount ; target++){
             int take = prev[target];
             int notTake = 0;
             if(target >= coins[ind-1]){
                 notTake = curr[target-coins[ind-1]];
             }
             curr[target] = take+notTake;
         }
         prev = curr;
     }
     return curr[amount];

//        @Select("select amount from inv_amount where lender_id  = #{lenderId} and is_active = 1 order by public_id desc limit 1")
//        Integer getInvestAmount(@Param("lenderId")Integer lenderId);
//
//        @Insert("insert into inv_amount_details (lender_id,low,mid,high,created_at) values(#{lenderId},#{lowRisk},#{mediumRisk},#{highRisk},#{createdAt})")
//        void saveRiskCategoryInAmountDetails(Integer lenderId, Integer lowRisk, Integer mediumRisk, Integer highRisk, LocalDateTime
//        createdAt);
//
//
//        int totalAmount = investorMapper.getInvestAmount(lender.getLenderId());
//        int lowRisk = (totalAmount*riskCategoryDto.getLowRisk())/100;
//        int mediumRisk = (totalAmount*riskCategoryDto.getMediumRisk())/100;
//        int highRisk = (totalAmount*riskCategoryDto.getHighRisk())/100;
//        investorMapper.saveRiskCategoryInAmountDetails(lender.getLenderId(),lowRisk,mediumRisk,highRisk,LocalDateTime.now());
    }
}
