package leetcode.backTracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartitionKEqual {
    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets(new int[]{4,3,2,3,5,2,1},4));
    }
    static boolean partition(int[] nums,int k){
        int totalSum = 0 ;
        for(int num : nums){
            totalSum += num;
        }
        Arrays.sort(nums);
        if(totalSum%k != 0){
            return false;
        }
        return backTracking(nums,totalSum/k,0,0,new HashSet<>(),k);
    }
    static boolean backTracking(int[] nums, int target, int index, int sum, Set<Integer> set, int k){
        if(k == 0){
            return true;
        }if(sum == target){
            return backTracking(nums,target,0,0,set,k-1);
        }for(int i = index ; i < nums.length ; i++){
            if(sum+nums[i] > target ){
                return false;
            }
            if(set.contains(i)){
                continue;
            }
            set.add(i);
            if(backTracking(nums,target,i+1,sum+nums[i],set,k)){
                return true;
            }
            set.remove(i);
            return backTracking(nums,target,i+1,sum,set,k);
        }
        return false;
    }
    static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }

        //sum%k must equal to 0 if not just return false
        //if we have to divide the array greater than array size return false(we can't)
        if(sum%k!=0 || nums.length<k) return false;

        //sort so we can take last element and start filling our bucket
        Arrays.sort(nums);

        //our target is sum/k and we have to find this in nums, k times then it is valid
        return canPartitionKSubsets(nums,sum/k,nums.length-1,new int[k]);

    }
    static boolean canPartitionKSubsets(int a[],int target,int i,int bucket[]){

        //we have taken all the elements
        if(i==-1)
            return true;

        //start filling the buckets
        for(int j=0;j<bucket.length;j++){

            //can we take this ith element
            if(bucket[j]+a[i]<=target){

                //if we take this element
                bucket[j]+=a[i];

                //go to next element (in our case go to smallest ele bcz we sorted)
                //if we can fill all buckets then return true
                if(canPartitionKSubsets(a,target,i-1,bucket))
                    return true;

                //means we can't fill other buckets if we take ith element so leave this element
                bucket[j]-=a[i];

            }

            //if our bucket is empty means we have not taken any elements in the buckets
            if(bucket[j]==0)
                break;

        }

        //all buckets are full but i is pointing to some element (elements still left)
        //or our bucket is empty means we haven't take any element (not valid)
        return false;

    }
}

