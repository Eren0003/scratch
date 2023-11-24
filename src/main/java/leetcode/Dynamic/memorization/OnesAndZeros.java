package leetcode.Dynamic.memorization;

import java.util.HashMap;

public class OnesAndZeros {
    public static void main(String[] args) {
        String[] strs = {"10","0001","111001","1","0"};
        int m = 5 ;
        int n = 3 ;
        System.out.println(oneZero(strs,m,n));
    }
    static int oneZero(String[] strs,int m ,int n){
        HashMap<String,int[]> map = new HashMap<>();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0 ; i < strs.length ; i++){
            int ones = 0 ; int zeros = 0 ;
            for(char a : strs[i].toCharArray()){
                if(a == '0'){
                    zeros++;
                }else{
                    ones++;
                }
            }
            map.put(strs[i],new int[]{zeros,ones});
        }
//        return dfs(strs,0,m,n,map,dp);
        for(String s : strs){
            int [] count = map.get(s);
            for(int zeros = m ; zeros >= count[0] ; zeros--){
                for(int ones = n ; ones >= count[1]; ones--){
                    dp[zeros][ones] = Math.max(dp[zeros-count[0]][ones-count[1]]+1,dp[zeros][ones]);
                }
            }
        }
        return dp[m][n];
    }
    static int dfs(String[] strs,int index ,int zeros,int ones ,HashMap<String,int[]> map,int[][][]dp){
        if(index == strs.length || zeros+ones == 0){
            return 0;
        }
        if(dp[zeros][ones][index] > 0){
            return dp[zeros][ones][index];
        }
        int[] temp = map.get(strs[index]);
        int consider = 0 ;
        if(zeros >= temp[0] && ones >= temp[1]) {
            consider = 1 + dfs(strs, index + 1, zeros - temp[0], ones - temp[1], map, dp);
        }
        int skip = dfs(strs,index+1,zeros,ones,map,dp);
        dp[zeros][ones][index] = Math.max(consider,skip);
        return dp[zeros][ones][index];
    }
}
