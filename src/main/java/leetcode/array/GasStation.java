package leetcode.array;

import java.util.Arrays;

public class GasStation {
    public static void main(String[] args) {
        System.out.println(station(new int[]{6,1,4,3,5},new int[]{3,8,2,4,2}));
    }
    static int station(int[] gas,int [] cost){
        int [] result = new int[gas.length];
        int gasSum = 0 ;
        int costSum = 0 ;
        for(int i = 0 ; i < gas.length ; i++){
            result[i] = gas[i]-cost[i];
            gasSum += gas[i];
            costSum += cost[i];
        }
        if(gasSum >= costSum){
            int total = 0 ;
            int index = -1 ;
            for(int i = 0 ; i < gas.length ; i++) {
                index = i;
                if (result[i] >= 0) {
                    while (i < gas.length) {
                        total += result[i];
                        if(total <  0){
                            total = 0 ;
                            break;
                        }
                        i++;
                        if (i == gas.length) {
                            return index;
                        }
                    }
                }
            }
        }
        return -1;
    }

}
