package leetcode;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AvoidFloodInCity {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(avoidFlood(new int[]{3,5,4,0,1,0,1,5,2,8,9})));
        LocalDate date = LocalDate.now();
        System.out.println(LocalDate.now().minusDays(1));
    }
    static int[] avoidFlood(int[] rains){
        Set<Integer> set = new HashSet<>();
        int[] result = new int[rains.length];
        for(int i = 0 ; i < rains.length ; i++){
            if(set.contains(rains[i])){
                return new int[0];
            }
           if(rains[i] > 0){
               set.add(rains[i]);
               result[i] = -1;
           }else{
               int index = i;
               if(!set.isEmpty()) {
                   while (index < rains.length) {
                       if (rains[index] != 0) {
                           break;
                       }
                       index++;
                   }
                   if (index < rains.length) {
                       for (int j = index ; j < rains.length ; j++) {
                           if (set.contains(rains[j])) {
                               result[i] = rains[j];
                               set.remove(rains[j]);
                               break;
                           }
                       }
                   } if(result[i] == 0) {
                       for (int j : set) {
                           result[i] = j;
                           set.remove(j);
                           break;
                       }
                   }
               }
               else{
                   result[i] = 1;
               }
           }
        }
        return result;
    }
}
