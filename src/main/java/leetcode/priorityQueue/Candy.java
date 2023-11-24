package leetcode.priorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1,3,2,2,1};
        System.out.println(candy(ratings));
    }
    static int candy (int [] ratings){
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[] result = new int[ratings.length];
        Arrays.fill(result,1);
        for(int i = 0 ; i < ratings.length ; i++){
            queue.offer(new int[]{ratings[i],i});
        }
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if(curr[1] == 0){
                if(ratings[curr[1]] > ratings[curr[1]+1]){
                    result[curr[1]] = result[curr[1]+1]+1;
                }
            }else if(curr[1] == ratings.length-1){
                if(ratings[curr[1]] > ratings[curr[1]-1]){
                    result[curr[1]] = result[curr[1]-1]+1;
                }
            }else{
                if(ratings[curr[1]] == ratings[curr[1]+1] && ratings[curr[1]+1] == ratings[curr[1]-1]){
                    continue;
                }
                if(ratings[curr[1]] > ratings[curr[1]-1] && ratings[curr[1]] > ratings[curr[1]+1]){
                    if(ratings[curr[1]+1] > ratings[curr[1]-1]){
                        result[curr[1]] = result[curr[1]+1]+1;
                    }else{
                        result[curr[1]] = result[curr[1]-1]+1;
                    }
                }else if(ratings[curr[1]-1] > ratings[curr[1]+1] ){
                    if(ratings[curr[1]-1] < ratings[curr[1]]){
                        result[curr[1]] = result[curr[1]-1]+1;
                    }else if(ratings[curr[1]+1] < ratings[curr[1]]){
                        result[curr[1]] = result[curr[1]+1]+1;
                    }
                }else{
                    if(ratings[curr[1]-1] < ratings[curr[1]]){
                        result[curr[1]] = result[curr[1]-1]+1;
                    }else if(ratings[curr[1]+1] < ratings[curr[1]]){
                        result[curr[1]] = result[curr[1]+1]+1;
                    }
                }
            }
        }
        int sum =  0 ;
        for(int i : result){
            sum  += i;
        }
        System.out.println(Arrays.toString(result));
        return sum;
    }
}
