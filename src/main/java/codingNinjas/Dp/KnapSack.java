package codingNinjas.Dp;

import java.util.Arrays;

public class KnapSack {
    public static void main(String[] args) {
        int weight = 8;
        int[] points = {1,2,5,6};
        int[]weights = {2,3,4,5};
        System.out.println(maxWeight(weight,weights,points));
    }
    static int maxWeight(int maxWeight ,int [] weight,int[] value){
        int[] curr = new int[maxWeight+1];
        int[] prev = new int[maxWeight+1];
        for(int ind = 1; ind <= weight.length ; ind++){
            for(int w = 1 ; w <= maxWeight ; w++){
                int notTake = prev[w];
                int take = 0 ;
                if(w >= value[ind-1]){
                    take = value[ind-1]+prev[w-value[ind-1]];
                }
                curr[w] = Math.max(take,notTake);
            }
            prev = curr ;
            curr = new int[maxWeight+1];
        }
        return prev[maxWeight];
    }
}
