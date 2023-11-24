package leetcode.priorityQueue;

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        System.out.println(task(tasks, 2));
    }
    static int task (char[] tasks , int n){
        int[] nums = new int[26];
        int max = 0 ;
        int maxCount = 0;
        for(char task : tasks) {
            int num = task - 'A';
            nums[num] += 1;
            max = Math.max(max,nums[num]);
        }
        for(int i :nums){
            if(max == i){
                maxCount += 1;
            }
        }
        return Math.max(tasks.length ,((max-1)*(n+1))+maxCount);
    }

}
