package leetcode.SlidingWindow;

public class Find132Pattern {
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        System.out.println(find132Pattern(nums));
    }
    static boolean find132Pattern(int[] nums){
        if(nums.length < 3){
            return false;
        }if(nums.length == 3 ){
            if(nums[1] > nums[2] && nums[1] > nums[0] && nums[2] > nums[0]){
                return true;
            }else{
                return false;
            }
        }
        for(int i = 1 ; i < nums.length-1 ; i++){
            if(nums[i] > nums[i+1] && nums[i] > nums[i-1] && nums[i+1] > nums[i-1]){
                return true;
            }
        }
        return false;
    }
}
